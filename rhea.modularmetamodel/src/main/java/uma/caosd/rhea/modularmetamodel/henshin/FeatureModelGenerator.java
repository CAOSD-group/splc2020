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
		
		List<EObject> modelObjects = generateAllPossibleModels(prefixName, features);
		for (EObject m : modelObjects) {
			henshin.saveModel(m, TEMPORAL_FM);
			FeatureModel fmTransformed = (FeatureModel) EMFIO.loadModel(this.staticMetamodels, basedir + TEMPORAL_FM);
			completeFMs.add(fmTransformed);
		}
		Utils.cleanUp(basedir + TEMPORAL_FOLDER);
		
		completeFMs = filterValidFeatureModels(completeFMs, features);
		return completeFMs;
	}
	
	private List<EObject> generateAllPossibleModels(String prefixName, List<String> features) {
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
		
		// Models to be transformed with Henshin
		Stack<EObject> modelsToTransform = new Stack<EObject>();
		modelsToTransform.add(initialModel);
		
		while (!modelsToTransform.isEmpty()) {
			EObject m = modelsToTransform.pop();
			
			// Apply all language generators to the current model with Henshin
			List<EObject> modelsTransformed = this.applyGenerators(m, features);
			
			// Remove duplicates
			for (EObject mt : modelsTransformed) {
				if (!allModels.stream().anyMatch(m2 -> EcoreUtil.equals(mt, m2))) {
					allModels.add(mt);
					modelsToTransform.add(mt);
				}
			}
		}
		return allModels;
	}
	
	/*
	public List<FeatureModel> generateAllFeatureModels(String prefixName, List<String> features) {
		List<FeatureModel> completeFMs = new ArrayList<FeatureModel>();
		boolean end = false;
		
		// Initialize with empty feature model
		List<FeatureModel> modelsToTransform = new ArrayList<FeatureModel>();
		FeatureModel initialEmptyFM = createEmptyFeatureModel(prefixName);
		modelsToTransform.add(initialEmptyFM);
		
		while (!end) {
			end = true;
			List<FeatureModel> newModelsToTransform = new ArrayList<FeatureModel>();
			
			for (FeatureModel m : modelsToTransform) {
				if (isComplete(m, features)) {
					completeFMs.add(m);
				} else {
					List<FeatureModel> auxModelsTransformed = this.applyGenerators(m, features);
					newModelsToTransform.addAll(auxModelsTransformed);
					end = false;
				}
			}
			modelsToTransform = newModelsToTransform;
		}
		completeFMs = filterValidFeatureModels(completeFMs);
		return completeFMs;
	}
	*/
	
	private List<EObject> applyGenerators(EObject model, List<String> features) {
		List<EObject> fms = new ArrayList<EObject>();
		
//		// Serialize the static model
//		try {
//			EMFIO.saveModel(fm, this.dynamicMetamodels, basedir + TEMPORAL_FM);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		// Load the model with Henshin
//		EObject model = henshin.loadModel(TEMPORAL_FM);
//		
		for (Module module : this.generators) {
			for (Unit unit : module.getUnits()) {
				for (String featureName : features) {
					Map<String, String> parameters = Map.of("name", featureName);
					
					List<EObject> modelsTransformed = this.henshin.executeRuleForAllMatches(unit, parameters, model);
					//System.out.println("modelsTransformed: " + modelsTransformed.size());
					fms.addAll(modelsTransformed);
					// Serialize the models and load them statically
//					for (EObject m : modelsTransformed) {
//						henshin.saveModel(m, TEMPORAL_FM);
//						FeatureModel fmTransformed = (FeatureModel) EMFIO.loadModel(this.staticMetamodels, basedir + TEMPORAL_FM);
//						fms.add(fmTransformed);
//					}
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
