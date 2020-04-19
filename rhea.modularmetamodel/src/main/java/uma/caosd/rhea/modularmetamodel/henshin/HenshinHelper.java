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
	
	public HenshinHelper(String basedir) {
		this.rs = new HenshinResourceSet(basedir);
		this.engine = new EngineImpl();
	}
	
	public void registerMetamodel(EPackage metamodel) {
		rs.getPackageRegistry().put(metamodel.getNsURI(), metamodel);
	}
	
	public EObject loadModel(String modelPath) {
		Resource res = rs.getResource(modelPath);
		EObject modelRoot = res.getContents().get(0);
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
		System.out.println(rs);
		System.out.println(modulePath);
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
		EObject modelCopy = EcoreUtil.copy(model);
		
		// Initialize the graph
		EGraph graph = new EGraphImpl(modelCopy);
		
		// Set parameters
		Match partialMatch = new MatchImpl(rule);
		for (Parameter p : rule.getParameters()) {
			if (p.getKind().equals(ParameterKind.IN)) {
				partialMatch.setParameterValue(p, parameters.get(p.getName()));
			}
		}
		
		System.out.println("rule: " + rule);
		List<EObject> results = new ArrayList<EObject>();
		for (Match match : engine.findMatches(rule, graph, partialMatch)) {
			System.out.println(match);
			
			// Copy the model
			EObject m = EcoreUtil.copy(modelCopy);
			
			// Initialize the graph:
			EGraph g = new EGraphImpl(m);
						
			UnitApplication application = new UnitApplicationImpl(engine, g, match.getRule(), match);
			//RuleApplication application = new RuleApplicationImpl(engine, g, match.getRule(), match);
			//application.setCompleteMatch(match);
			application.execute(new LoggingApplicationMonitor());
			
			results.add(m);
		}
		return results;
	}
}
