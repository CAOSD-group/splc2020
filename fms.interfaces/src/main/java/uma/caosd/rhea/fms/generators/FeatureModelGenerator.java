package uma.caosd.rhea.fms.generators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Engine;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.interpreter.UnitApplication;
import org.eclipse.emf.henshin.interpreter.impl.EGraphImpl;
import org.eclipse.emf.henshin.interpreter.impl.EngineImpl;
import org.eclipse.emf.henshin.interpreter.impl.MatchImpl;
import org.eclipse.emf.henshin.interpreter.impl.UnitApplicationImpl;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Parameter;
import org.eclipse.emf.henshin.model.ParameterKind;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.Unit;
import org.eclipse.emf.henshin.model.resource.HenshinResourceSet;

import uma.caosd.rhea.BasicFMmetamodel.Alternative;
import uma.caosd.rhea.BasicFMmetamodel.FeatureModel;
import uma.caosd.rhea.BasicFMmetamodel.OrGroup;

public class FeatureModelGenerator {
	private String basedir;
	private EPackage metamodel;
	private HenshinResourceSet resourceSet;
	private Engine engine;
	private List<Module> modules;	
	
	public FeatureModelGenerator(String basedir, EPackage initialMetamodel, List<String> generatorModuleNames) {
		this.basedir = basedir;
		this.metamodel = initialMetamodel;
		
		initializeHenshin(generatorModuleNames);
	}
	
	public void initializeHenshin(List<String> generatorModuleNames) {
		// Create a resource set for the working directory "my/working/directory":
		resourceSet = new HenshinResourceSet(basedir);
		
		// If static meta-models are involved, initialize the relevant packages:
		metamodel.eClass();
		
		// If dynamic meta-models are involved, register it
		resourceSet.getPackageRegistry().put(metamodel.getNsURI(), metamodel);
		
		// Register relevant resource factories for model loading (XMIResourceFactoryImpl usually works): 
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		
		// Load the Henshin modules:
		modules = new ArrayList<Module>();
		for (String moduleName : generatorModuleNames) {
			modules.add(resourceSet.getModule(moduleName));
		}
		
		// Prepare the engine:
		engine = new EngineImpl();
	}

	public FeatureModel generateEmptyFeatureModel(String fmName) {
		EFactory mFactory = metamodel.getEFactoryInstance();
		EClass eclass = (EClass) metamodel.getEClassifier("FeatureModel");
		FeatureModel fm = (FeatureModel) mFactory.create(eclass);
		fm.setName(fmName);
		
		return fm;
	}

	public List<FeatureModel> applyGenerators(FeatureModel fm, List<String> features) {
		List<FeatureModel> fms = new ArrayList<FeatureModel>();
	
		for (Module module : modules) {
			for (Unit unit : module.getUnits()) {
				for (String featureName : features) {
					Map<String, String> parameters = Map.of("name", featureName);
					
					List<EObject> modelsTransformed = executeRuleForAllMatches((Rule) unit, parameters, fm);
					fms.addAll((Collection<? extends FeatureModel>) modelsTransformed);
				}
			}	
		}
		
		return fms;
	}
	
	public List<FeatureModel> generateFeatureModels(FeatureModel fm, List<String> features) {
		List<FeatureModel> completeFMs = new ArrayList<FeatureModel>();
		
		boolean end = false;
		List<FeatureModel> fms = this.applyGenerators(fm, features);
		while (!end) {
			end = true;
			List<FeatureModel> allFMs = new ArrayList<FeatureModel>();
			
			for (FeatureModel m : fms) {
				if (containsAllFeatures(m, features)) {
					completeFMs.add(m);
				} else {
					List<FeatureModel> newFMs = this.applyGenerators(m, features);
					allFMs.addAll(newFMs);
					end = false;
				}
			}
			fms = allFMs;
		}
		completeFMs = filterValidFeatureModels(completeFMs);
		return completeFMs;
	}
	
//	public FeatureModel applyGenerator(Unit generator, FeatureModel fm, String featureName) {
//		// Initialize the graph:
//		EGraph graph = new EGraphImpl(fm);
//					
//		UnitApplication application = new UnitApplicationImpl(engine, graph, generator, null);
//		application.setParameterValue("name", featureName);
//		application.execute(null);
//		
//		return fm;
//	}
	
	private boolean containsAllFeatures(FeatureModel fm, List<String> features) {
		for (String name : features) {
			if (!fm.getFeatures().stream().anyMatch(f -> f.getName().equals(name))) {
				return false;
			}
		}
		return true;
	}
	
	private List<EObject> executeRuleForAllMatches(Rule rule, Map<String,String> parameters, EObject model) {						
		EObject modelCopy = EcoreUtil.copy(model);
		
		// Initialize the graph:
		EGraph graph = new EGraphImpl(modelCopy);
		
		// Set parameters
		Match partialMatch = new MatchImpl(rule);
		for (Parameter p : rule.getParameters()) {
			if (p.getKind().equals(ParameterKind.IN)) {
				partialMatch.setParameterValue(p, parameters.get(p.getName()));
			}
		}
		
		List<EObject> results = new ArrayList<EObject>();
		for (Match match : engine.findMatches(rule, graph, partialMatch)) {
			System.out.println(match);
			
			// Copy the model
			EObject m = EcoreUtil.copy(modelCopy);
			
			// Initialize the graph:
			EGraph g = new EGraphImpl(m);
						
			UnitApplication application = new UnitApplicationImpl(engine, g, match.getRule(), match);
			application.execute(null);
			
			results.add(m);
		}
		return results;
	}
	
	private List<FeatureModel> filterValidFeatureModels(List<FeatureModel> fms) {
		// Feature groups cannot be leafs
		fms = fms.stream().filter(fm -> !fm.getFeatures().stream().anyMatch(f -> f.isLeaf() && (f instanceof Alternative || f instanceof OrGroup))).collect(Collectors.toList());
		// Feature groups must have at least 2 childs
		fms = fms.stream().filter(fm -> !fm.getFeatures().stream().anyMatch(f -> f.getChildren().size() < 2 && (f instanceof Alternative || f instanceof OrGroup))).collect(Collectors.toList());
		
		
		return fms;
	}
}
