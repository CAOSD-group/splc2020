package uma.caosd.rhea.fms.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Engine;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.interpreter.RuleApplication;
import org.eclipse.emf.henshin.interpreter.UnitApplication;
import org.eclipse.emf.henshin.interpreter.impl.EGraphImpl;
import org.eclipse.emf.henshin.interpreter.impl.EngineImpl;
import org.eclipse.emf.henshin.interpreter.impl.MatchImpl;
import org.eclipse.emf.henshin.interpreter.impl.PartitionedEGraphImpl;
import org.eclipse.emf.henshin.interpreter.impl.RuleApplicationImpl;
import org.eclipse.emf.henshin.interpreter.impl.UnitApplicationImpl;
import org.eclipse.emf.henshin.interpreter.util.InterpreterUtil;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Parameter;
import org.eclipse.emf.henshin.model.ParameterKind;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.resource.HenshinResourceSet;

import uma.caosd.rhea.BasicFMmetamodel.FeatureModel;

public class HenshinHelper {
	private HenshinResourceSet resourceSet;
	private Engine engine;
	private int threads;						// Number of threads to be used
	
	public HenshinHelper(String basedir) {
		// Determine number of threads to be used
		threads = Math.max(Runtime.getRuntime().availableProcessors() / 2, 1);
		
		// Create a resource set for the working directory "my/working/directory":
		resourceSet = new HenshinResourceSet(basedir);
		
		// If static meta-models are involved, initialize the relevant packages:
		//metamodel.eClass();
		
		// if dynamic meta-model, register it
		//resourceSet.getPackageRegistry().put(metamodel.getNsURI(), metamodel);
		
		// Register relevant resource factories for model loading (XMIResourceFactoryImpl usually works): 
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		
		// Prepare the engine:
		engine = new EngineImpl();
		engine.getOptions().put(Engine.OPTION_WORKER_THREADS, threads);
		engine.getOptions().put(Engine.OPTION_DESTROY_MATCHES, true);
		//engine.getOptions().put(Engine.OPTION_INJECTIVE_MATCHING, false);
		//engine.getOptions().put(Engine.OPTION_INJECTIVE_MATCHING, false);
	}

	/**
	 * Find all matches and apply the transformation to each match individually.
	 * 
	 * @param modulePath		Relative path (relative to base dir) of the Henshin module containing the rule.
	 * @param ruleName			Rule's name in the Henshin module.
	 * @param parameters		Parameters of the unit "parameter's name" -> "parameter's value".
	 * @param modelPath			Relative path (relative to base dir) of the model to be transformed.
	 * @return					List of models transformed.
	 */
	public List<EObject> executeRuleForAllMatches(String modulePath, String ruleName, Map<String,String> parameters, String modelPath) {
		// Register the metamodel
		//resourceSet.getPackageRegistry().put(metamodel.getNsURI(), metamodel);
		
		// Load the Henshin module
		Module module = resourceSet.getModule(modulePath);
		
		// Find the rule
		Rule rule = (Rule) module.getUnit(ruleName);
		
		// Load the model as a resource
		Resource resource = resourceSet.getResource(modelPath);
		
		// Get the model
		EObject model = resource.getContents().get(0);
		
		EObject modelCopy = EcoreUtil.copy(model);
		
		// Initialize the graph:
		EGraph graph = new EGraphImpl(modelCopy);
		
		Match partialMatch = new MatchImpl(rule);
		// Set parameters
		for (Parameter p : rule.getParameters()) {
			if (p.getKind().equals(ParameterKind.IN)) {
				System.out.println("Parameter (IN): " + p);
				partialMatch.setParameterValue(p, parameters.get(p.getName()));
			}
		}
		
		List<EObject> results = new ArrayList<EObject>();
		for (Match match : engine.findMatches(rule, graph, partialMatch)) {
			System.out.println(match);
			// Load feature model
			EObject m = EcoreUtil.copy(modelCopy);
			
			// Initialize the graph:
			EGraph g = new EGraphImpl(m);
						
			UnitApplication application = new UnitApplicationImpl(engine, g, match.getRule(), match);
			// Set parameters
//			for (Parameter p : match.getRule().getParameters()) {
//				if (p.getKind().equals(ParameterKind.IN)) {
//					System.out.println("Parameter (IN): " + p);
//					application.setParameterValue(p.getName(), parameters.get(p.getName()));
//				}
//			}
			application.execute(null);
			
			results.add(m);
		}
	
		System.out.println("******** All models ***********");
		for (EObject o : results) {
			FeatureModel f = (FeatureModel) o;
			System.out.println(f.getFeatures());
		}
		return results;
	}
		
//		// Initialize the graph:
//		EGraph graph = new EGraphImpl(model);
//		
//		// Create partial match
//		Match partialMatch = new MatchImpl(rule);
//		// Set parameters
//		for (Parameter p : rule.getParameters()) {
//			if (p.getKind().equals(ParameterKind.IN)) {
//				partialMatch.setParameterValue(p, parameters.get(p.getName()));
//			}
//		}
//		
//		List<Match> matches = findMatches(resource, rule, parameters);
//		System.out.println("#Matches: " + matches.size());
//
//		graph.removeGraph(model);
//		
//		EObject m = EcoreUtil.copy(model);
//		
//		// Apply rule
//		RuleApplication application = new RuleApplicationImpl(engine);
//
//		List<EObject> results = new ArrayList<EObject>();
//		for (Match match : matches) {
//			System.out.println(match);
//			
//			System.out.println("#Models in graph (init loop): " + graph.getRoots().size());
//			m = EcoreUtil.copy(m);
//			graph.addGraph(m);
//			
//			System.out.println("#Models in graph (add): " + graph.getRoots().size());
//			//EGraph graph = new EGraphImpl(m);
//			//graph.remove(model);
//			application.setRule(match.getRule());
//			application.setEGraph(graph);
//			application.setCompleteMatch(match);
//			application.execute(null);
//			
//			System.out.println("#Models in graph (after application): " + graph.getRoots().size());
//			FeatureModel fm1 = (FeatureModel) graph.getRoots().get(0);
//			FeatureModel fm2 = (FeatureModel) graph.getRoots().get(1);
//			System.out.println("1: " + fm1.getFeatures());
//			System.out.println("2: " + fm2.getFeatures());
//			
//			FeatureModel fm = (FeatureModel) model;
//			System.out.println("Model: " + fm.getFeatures());
//			
//			FeatureModel fmM = (FeatureModel) m;
//			System.out.println("m: " + fmM.getFeatures());
//			
//			
//			//EObject res = EcoreUtil.copy(graph.getRoots().get(0));
//			results.add(model);
//			
//			graph.removeGraph(m);
//			
//		}
//		
//		
//		System.out.println("******** All models ***********");
//		for (EObject o : results) {
//			FeatureModel f = (FeatureModel) o;
//			System.out.println(f.getFeatures());
//		}
//		return null;
		
//		// Initialize the graph
//		EGraph graph = new PartitionedEGraphImpl(resource, threads);
//		
//		// Create partial match
//		Match partialMatch = new MatchImpl(rule);
//		// Set parameters
//		for (Parameter p : rule.getParameters()) {
//			if (p.getKind().equals(ParameterKind.IN)) {
//				partialMatch.setParameterValue(p, parameters.get(p.getName()));
//			}
//		}
//		
//		
////		Match partialMatch = new MatchImpl(rule);
////		// Set parameters
////		for (Parameter p : rule.getParameters()) {
////			if (p.getKind().equals(ParameterKind.IN)) {
////				partialMatch.setParameterValue(p, parameters.get(p.getName()));
////			}
////		}
////		
////		List<Match> matches = InterpreterUtil.findAllMatches(engine, rule, graph, partialMatch);
////		System.out.println("Matches: " + matches.size());
////		for (Match match : matches) {
////			System.out.println(match);
////			
////			// Copy the model to not override the original one
////			//EObject m = EcoreUtil.copy(model);
////			//EGraph g = new EGraphImpl(m);
////			// Apply the rule
////			//RuleApplication application = new RuleApplicationImpl(engine, g, rule, match);
////			//application.setCompleteMatch(match);
////			//application.execute(null);
////			//System.out.println(((FeatureModel) graph.getRoots().get(0)).getFeatures());
////			//modelsTransformed.add(m);
////		}
//		
//		// Remove the container object:
//		//EObject container = resource.getContents().get(0);
//		//graph.remove(container);
//		// Get original model
//		EObject model = EcoreUtil.copy(graph.getRoots().get(0));
//		
//		
//		// Initialize the application of the rule
//		RuleApplication application = new RuleApplicationImpl(engine);
//		application.setRule(rule);
//		application.setEGraph(graph);
//		
////		System.out.println(graph.toString());
////		System.out.println(graph.getRoots().get(0));
//		List<EObject> results = new ArrayList<EObject>();
//		
//		
//		
//		// Find matches
//		List<Match> matches = InterpreterUtil.findAllMatches(engine, rule, graph, partialMatch);
//		System.out.println("#Matches: " + matches.size());
//		for (Match match : matches) {
//			System.out.println(match);
//			
//			EObject m = EcoreUtil.copy(model);
//			
//			EGraph g = new EGraphImpl(m);
//			// Apply rule
//			application.setEGraph(g);
//			application.setCompleteMatch(match);
//			application.execute(null);
//			
//			//System.out.println("Graph size: " + graph.size());
//			
//			//System.out.println(graph.toString());
//			results.add(g.getRoots().get(0));
//		}
//		
//		return results;
//		
//		////////////////////////////////////
//		List<EObject> modelsTransformed = new ArrayList<EObject>();
//		
//		// Load the Henshin module
//		Module module = resourceSet.getModule(modulePath);
//		
//		// Load the rule
//		Rule rule = (Rule) module.getUnit(ruleName);
//		
//		// Initialize the graph
//		EGraph graph = new EGraphImpl(model);
//		
//		Match partialMatch = new MatchImpl(rule);
//		// Set parameters
//		for (Parameter p : rule.getParameters()) {
//			if (p.getKind().equals(ParameterKind.IN)) {
//				partialMatch.setParameterValue(p, parameters.get(p.getName()));
//			}
//		}
//		
//		List<Match> matches = InterpreterUtil.findAllMatches(engine, rule, graph, partialMatch);
//		System.out.println("Matches: " + matches.size());
//		for (Match match : matches) {
//			System.out.println(match);
//			
//			// Copy the model to not override the original one
//			EObject m = EcoreUtil.copy(model);
//			EGraph g = new EGraphImpl(m);
//			// Apply the rule
//			RuleApplication application = new RuleApplicationImpl(engine, g, rule, match);
//			//application.setCompleteMatch(match);
//			application.execute(null);
//			System.out.println(((FeatureModel) graph.getRoots().get(0)).getFeatures());
//			modelsTransformed.add(m);
//		}
//		return modelsTransformed;
	
	private List<Match> findMatches(Resource resource, Rule rule, Map<String,String> parameters) {
		// Initialize the graph
		EGraph graph = new PartitionedEGraphImpl(resource, threads);
		
		// Create partial match
		Match partialMatch = new MatchImpl(rule);
		// Set parameters
		for (Parameter p : rule.getParameters()) {
			if (p.getKind().equals(ParameterKind.IN)) {
				partialMatch.setParameterValue(p, parameters.get(p.getName()));
			}
		}
		return InterpreterUtil.findAllMatches(engine, rule, graph, partialMatch);
	}

}