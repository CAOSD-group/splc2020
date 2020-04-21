package uma.caosd.rhea.modularmetamodel.henshin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Unit;

import uma.caosd.rhea.BasicConstraints.BasicConstraintsPackage;
import uma.caosd.rhea.BasicFMmetamodel.Alternative;
import uma.caosd.rhea.BasicFMmetamodel.BasicFMmetamodelFactory;
import uma.caosd.rhea.BasicFMmetamodel.BasicFMmetamodelPackage;
import uma.caosd.rhea.BasicFMmetamodel.FeatureModel;
import uma.caosd.rhea.BasicFMmetamodel.OrGroup;
import uma.caosd.rhea.modularmetamodel.FeatureModelHelper;
import uma.caosd.rhea.modularmetamodel.utils.EMFIO;
import uma.caosd.rhea.modularmetamodel.utils.Utils;

/**
 * Generate all possible feature models with Henshin.
 * 
 * @author Jose-Miguel Horcas
 *
 */
public class FeatureModelGenerator {
	public static final BasicFMmetamodelPackage BASIC_FMS_METAMODEL = BasicFMmetamodelPackage.eINSTANCE;
	public static final String TEMPORAL_FOLDER = "tmp/";
	public static final String TEMPORAL_FM = TEMPORAL_FOLDER + "fm.xmi";
	private HenshinHelper henshin;
	private List<EPackage> dynamicMetamodels; 	// loaded from the filepath to work with Henshin.
	private List<EPackage> staticMetamodels;	// loaded from the generated code to work with feature models
	private List<Module> generators;
	private String basedir;
	
	// TENGO QUE CARGAR LOS METMODELOS DE FORMA ESTÁTICA (PARA TRABAJAR CÓMODAMENTE CON LOS FEATURE MODELS) Y DE FORMA DINÁMICA (PARA HENSHIN).
	/**
	 * 
	 * @param basedir		Base working directory.
	 * @param dynamicMetamodels	Paths for the metamodels.
	 * @param generators	Paths for the Henshin modules (generators).
	 */
	public FeatureModelGenerator(String basedir, List<String> dynamicMetamodelsPaths, List<EPackage> staticMetamodels, List<String> generatorsPaths) {
		this.basedir = basedir;
		this.henshin = new HenshinHelper(basedir);
		this.staticMetamodels = staticMetamodels;
		
		this.dynamicMetamodels = new ArrayList<EPackage>();
		for (String mm : dynamicMetamodelsPaths) {
			EPackage metamodel = henshin.registerMetamodel(mm);
			this.dynamicMetamodels.add(metamodel);
		}
		
		// Get Henshin modules
		this.generators = new ArrayList<Module>();
		for (String genFilepath : generatorsPaths) {
			Module henshinModule = henshin.getModule(genFilepath);
			this.generators.add(henshinModule);
		}
	}
	
	public FeatureModel createEmptyFeatureModel(String name) {
		EPackage initialMetamodel = staticMetamodels.get(0);
		EFactory mFactory = initialMetamodel.getEFactoryInstance();
		EClass eClass = (EClass) initialMetamodel.getEClassifier("FeatureModel");
		EObject model = mFactory.create(eClass);
		EAttribute eAttributeName = (EAttribute) eClass.getEStructuralFeature("name");
		model.eSet(eAttributeName, "fm");

		return (FeatureModel) model;
	}
	
	public List<FeatureModel> generateAllFeatureModels(String prefixName, List<String> features) {
		List<FeatureModel> completeFMs = new ArrayList<FeatureModel>();
		
		List<FeatureModel> fms = generateAllPossibleModels(prefixName, features);
		for (FeatureModel m : fms) {
			if (FeatureModelHelper.isComplete(m, features)) {
				completeFMs.add(m);
			}
		}
		System.out.println("completeModels: " + completeFMs.size());
		return completeFMs;
	}
	
	private List<FeatureModel> generateAllPossibleModels(String prefixName, List<String> features) {
		// Initialize with empty feature model
		FeatureModel initialEmptyFM = createEmptyFeatureModel(prefixName);
		try {
			EMFIO.saveModel(initialEmptyFM, this.staticMetamodels, basedir + TEMPORAL_FM);
		} catch (IOException e) {
			e.printStackTrace();
		}
		EObject initialModel = henshin.loadModel(TEMPORAL_FM);
		
		// All models to be returned as result
		List<EObject> allModels = new ArrayList<EObject>();
		allModels.add(initialModel);
		
		// All models as feature model to be returned as result
		List<FeatureModel> allFMs = new ArrayList<FeatureModel>();
		allFMs.add(initialEmptyFM);
		
		// Models to be transformed with Henshin
		Stack<EObject> modelsToTransform = new Stack<EObject>();
		modelsToTransform.add(initialModel);
		
		
		while (!modelsToTransform.isEmpty()) {
			EObject m = modelsToTransform.pop();
			
			// Apply all language generators to the current model with Henshin
			List<EObject> modelsTransformed = this.applyGenerators(m, features);
			
			// Remove duplicates
			for (EObject mt : modelsTransformed) {
				henshin.saveModel(mt, TEMPORAL_FM);
				FeatureModel fm = (FeatureModel) EMFIO.loadModel(this.staticMetamodels, basedir + TEMPORAL_FM);
				if (FeatureModelHelper.isValid(fm)) {
					// Filter duplicated
					if (!allModels.stream().anyMatch(m2 -> EcoreUtil.equals(mt, m2))) {
						allModels.add(mt);
						allFMs.add(fm);
						modelsToTransform.add(mt);
					}
				}
			}
		}
		Utils.cleanUp(basedir + TEMPORAL_FOLDER);
		System.out.println("allModels: " + allModels.size());
		System.out.println("allFMs: " + allFMs.size());
		return allFMs;
	}
	
	private List<EObject> applyGenerators(EObject model, List<String> features) {
		List<EObject> fms = new ArrayList<EObject>();
		
		for (Module module : this.generators) {
			for (Unit unit : module.getUnits()) {
				for (String featureName : features) {
					Map<String, String> parameters = Map.of("name", featureName);
					
					List<EObject> modelsTransformed = this.henshin.executeRuleForAllMatches(unit, parameters, model);
					fms.addAll(modelsTransformed);
				}
			}	
		}
		return fms;
	}

	private boolean isFeatureModelComplete(FeatureModel fm, List<String> features) {
		// Check if all features are present in the feature model
		for (String name : features) {
			if (!fm.getFeatures().stream().anyMatch(f -> f.getName().equals(name))) {
				return false;
			}
		}
		return true;
	}
	
	private List<FeatureModel> filterValidFeatureModels(List<FeatureModel> fms, List<String> features) {
		
		// Feature model contains all features
		fms = fms.stream().filter(fm -> isFeatureModelComplete(fm, features)).collect(Collectors.toList());
		
		// Feature groups cannot be leafs
		fms = fms.stream().filter(fm -> !fm.getFeatures().stream().anyMatch(f -> f.isLeaf() && (f instanceof Alternative || f instanceof OrGroup))).collect(Collectors.toList());
		
		// Feature groups must have at least 2 childs
		fms = fms.stream().filter(fm -> !fm.getFeatures().stream().anyMatch(f -> f.getChildren().size() < 2 && (f instanceof Alternative || f instanceof OrGroup))).collect(Collectors.toList());
		
		return fms;
	}
	
}
