package uma.caosd.rhea.modularmetamodel.henshin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Engine;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.interpreter.UnitApplication;
import org.eclipse.emf.henshin.interpreter.impl.EGraphImpl;
import org.eclipse.emf.henshin.interpreter.impl.EngineImpl;
import org.eclipse.emf.henshin.interpreter.impl.LoggingApplicationMonitor;
import org.eclipse.emf.henshin.interpreter.impl.MatchImpl;
import org.eclipse.emf.henshin.interpreter.impl.PartitionedEGraphImpl;
import org.eclipse.emf.henshin.interpreter.impl.UnitApplicationImpl;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Parameter;
import org.eclipse.emf.henshin.model.ParameterKind;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.Unit;
import org.eclipse.emf.henshin.model.resource.HenshinResourceSet;

public class HenshinHelper {
	private HenshinResourceSet rs;
	private Engine engine;
	private int threads;
	
	public HenshinHelper(String basedir) {
		this.rs = new HenshinResourceSet(basedir);
		this.engine = new EngineImpl();
		
		// Determine number of threads to be used:
		this.threads = Math.max(Runtime.getRuntime().availableProcessors() / 2, 1);
		engine.getOptions().put(Engine.OPTION_WORKER_THREADS, threads);
		//engine.getOptions().put(Engine.OPTION_DESTROY_MATCHES, true);
	}
	
	public EPackage registerMetamodel(String metamodelPath) {
		Resource res = rs.getResource(metamodelPath);
		EPackage metamodel = (EPackage) res.getContents().get(0);
		rs.getPackageRegistry().put(metamodel.getNsURI(), metamodel);
		EcoreUtil.resolveAll(rs);
		
		/*System.out.println("**********");
		for (Resource r : rs.getResources()) {
			System.out.println("Resource: " + r);
		}
		System.out.println("**********");*/
		return metamodel;
	}
	
	public EObject loadModel(String modelPath) {
		Resource res = rs.getResource(modelPath);
		/*try {
			res.load(rs.getLoadOptions());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		EObject modelRoot = res.getContents().get(0);
		EcoreUtil.resolveAll(rs);
		return modelRoot;
	}
	
	public void saveModel(EObject model, String modelPath) {
		Resource res = rs.createResource(modelPath);
		res.getContents().add(model);

		try {
			res.save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Module getModule(String modulePath) {
		return rs.getModule(modulePath, true);
	}
	
	public List<EObject> executeRuleForAllMatches(Unit rule, Map<String,String> parameters, EObject model) {
		return executeRuleForAllMatches((Rule) rule, parameters, model);
	}
	
	public List<EObject> executeRuleForAllMatches(String modulePath, String ruleName, Map<String,String> parameters, String modelPath) {
		EObject model = loadModel(modelPath);
		Module module = rs.getModule(modulePath, true);
		Unit rule = module.getUnit(ruleName);
		return executeRuleForAllMatches((Rule) rule, parameters, model);
	}
	
	public List<EObject> executeRuleForAllMatches(String modulePath, String ruleName, Map<String,String> parameters, EObject model) {
		Module module = rs.getModule(modulePath, true);
		Unit rule = module.getUnit(ruleName);
		return executeRuleForAllMatches((Rule) rule, parameters, model);
	}
	
	private List<EObject> executeRuleForAllMatches(Rule rule, Map<String,String> parameters, EObject model) {						
		//EObject modelCopy = EcoreUtil.copy(model);
		
		// Initialize the graph
		EGraph graph = new PartitionedEGraphImpl(model, threads);
		
		// Set parameters
		Match partialMatch = new MatchImpl(rule);
		for (Parameter p : rule.getParameters()) {
			if (p.getKind().equals(ParameterKind.IN)) {
				partialMatch.setParameterValue(p, parameters.get(p.getName()));
			}
		}
		
		//System.out.println("rule: " + rule);
		List<EObject> results = new ArrayList<EObject>();
		for (Match match : engine.findMatches(rule, graph, partialMatch)) {
			//System.out.println(match);
			
			// Copy the model
			EObject m = EcoreUtil.copy(model);
			
			// Initialize the graph:
			EGraph g = new PartitionedEGraphImpl(m, threads);
						
			UnitApplication application = new UnitApplicationImpl(engine, g, match.getRule(), match);
			//RuleApplication application = new RuleApplicationImpl(engine, g, match.getRule(), match);
			//application.setCompleteMatch(match);
			//application.execute(new LoggingApplicationMonitor());
			application.execute(null);
			
			results.add(m);
		}
		return results;
	}
	
	
}
