package uma.caosd.rhea.modularmetamodel.henshin;

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
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Unit;

import uma.caosd.rhea.BasicFMmetamodel.Alternative;
import uma.caosd.rhea.BasicFMmetamodel.BasicFMmetamodelFactory;
import uma.caosd.rhea.BasicFMmetamodel.BasicFMmetamodelPackage;
import uma.caosd.rhea.BasicFMmetamodel.FeatureModel;
import uma.caosd.rhea.BasicFMmetamodel.OrGroup;
import uma.caosd.rhea.modularmetamodel.utils.EMFIO;

/**
 * Generate all possible feature models with Henshin.
 * 
 * @author Jose-Miguel Horcas
 *
 */
public class FeatureModelGenerator {
	/**
	 * Initial required metamodel.
	 */
	public static final EPackage BASIC_FM_METAMODEL = BasicFMmetamodelPackage.eINSTANCE;
	private HenshinHelper henshin;
	private List<EPackage> metamodels;
	private List<Module> generators;
	
	/**
	 * 
	 * @param basedir		Base working directory.
	 * @param metamodels	Paths for the metamodels.
	 * @param generators	Paths for the Henshin modules (generators).
	 */
	public FeatureModelGenerator(String basedir, List<String> metamodelsPaths, List<String> generatorsPaths) {
		this.henshin = new HenshinHelper(basedir);
		
		// Register main metamodel
		this.henshin.registerMetamodel(BASIC_FM_METAMODEL);
		
		// Register all metamodels
		this.metamodels = new ArrayList<EPackage>();
		for (String mm : metamodelsPaths) {
			EPackage metamodel = (EPackage) EMFIO.loadMetamodel(basedir + mm);
			this.metamodels.add(metamodel);
			//this.henshin.registerMetamodel(metamodel);	
		}
		
		// Get Henshin modules
		this.generators = new ArrayList<Module>();
		for (String genFilepath : generatorsPaths) {
			this.generators.add(this.henshin.getModule(genFilepath));
		}
	}
	
	public FeatureModel createEmptyFeatureModel(String name) {
		// Create a dyanmic model
		EFactory mFactory = BASIC_FM_METAMODEL.getEFactoryInstance();
		EClass eClass = (EClass) BASIC_FM_METAMODEL.getEClassifier("FeatureModel");
		EObject model = mFactory.create(eClass);
		EAttribute eAttributeName = (EAttribute) eClass.getEStructuralFeature("name");
		model.eSet(eAttributeName, name);
				
		return (FeatureModel) model;
	}
	
	public List<FeatureModel> generateAllFeatureModels(String prefixName, List<String> features) {
		List<FeatureModel> completeFMs = new ArrayList<FeatureModel>();
		boolean end = false;
		
		// Initialize with empty feature model
		FeatureModel initialEmptyFM = createEmptyFeatureModel(prefixName);
		Stack<FeatureModel> modelsToTransform = new Stack<FeatureModel>();
		modelsToTransform.add(initialEmptyFM);
		
		while (!modelsToTransform.isEmpty()) {
			FeatureModel fm = modelsToTransform.pop();
			List<FeatureModel> modelsTransformed = this.applyGenerators(fm, features);
			
			for (FeatureModel m : modelsTransformed) {
				if (isFeatureModelComplete(m, features)) {
					completeFMs.add(m);
				} else {
					modelsToTransform.add(m);
				}
			}
		}
		completeFMs = filterValidFeatureModels(completeFMs);
		return completeFMs;
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
	
	@SuppressWarnings("unchecked")
	private List<FeatureModel> applyGenerators(FeatureModel fm, List<String> features) {
		List<FeatureModel> fms = new ArrayList<FeatureModel>();
		
		for (Module module : this.generators) {
			for (Unit unit : module.getUnits()) {
				for (String featureName : features) {
					Map<String, String> parameters = Map.of("name", featureName);
					
					List<EObject> modelsTransformed = this.henshin.executeRuleForAllMatches(unit, parameters, fm);
					System.out.println("modelsTransformed: " + modelsTransformed.size());
					fms.addAll((Collection<? extends FeatureModel>) modelsTransformed);
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
	
	private List<FeatureModel> filterValidFeatureModels(List<FeatureModel> fms) {
		// Feature groups cannot be leafs
		fms = fms.stream().filter(fm -> !fm.getFeatures().stream().anyMatch(f -> f.isLeaf() && (f instanceof Alternative || f instanceof OrGroup))).collect(Collectors.toList());
		// Feature groups must have at least 2 childs
		fms = fms.stream().filter(fm -> !fm.getFeatures().stream().anyMatch(f -> f.getChildren().size() < 2 && (f instanceof Alternative || f instanceof OrGroup))).collect(Collectors.toList());
		
		return fms;
	}
	
}
