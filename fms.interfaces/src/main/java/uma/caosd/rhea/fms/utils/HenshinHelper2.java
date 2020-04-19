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
import org.eclipse.emf.henshin.interpreter.UnitApplication;
import org.eclipse.emf.henshin.interpreter.impl.EGraphImpl;
import org.eclipse.emf.henshin.interpreter.impl.EngineImpl;
import org.eclipse.emf.henshin.interpreter.impl.MatchImpl;
import org.eclipse.emf.henshin.interpreter.impl.UnitApplicationImpl;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Parameter;
import org.eclipse.emf.henshin.model.ParameterKind;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.resource.HenshinResourceSet;

public class HenshinHelper2 {
	private HenshinResourceSet resourceSet;
	private Engine engine;
	private int threads;						// Number of threads to be used
	
	public HenshinHelper2(String basedir) {
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
			application.execute(null);
			
			results.add(m);
		}
	/*
		System.out.println("******** All models ***********");
		for (EObject o : results) {
			FeatureModel f = (FeatureModel) o;
			System.out.println(f.getFeatures());
		}*/
		return results;
	}

}