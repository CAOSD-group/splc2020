package uma.caosd.rhea.fms.generators;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
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
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.Unit;
import org.eclipse.emf.henshin.model.resource.HenshinResourceSet;

import uma.caosd.rhea.BasicFMmetamodel.FeatureModel;

public class FeatureModelGenerator {
	private String basedir;
	private EPackage metamodel;
	private HenshinResourceSet resourceSet;
	private Engine engine;
	private Module module;	
	
	public FeatureModelGenerator(EPackage metamodel, String generatorsFilepath) {
		this.basedir = Paths.get(generatorsFilepath).getParent().toString();
		this.metamodel = metamodel;
		
		initializeHenshin(Paths.get(generatorsFilepath).getFileName().toString());
	}
	
	public void initializeHenshin(String generatorsFilepath) {
		// Create a resource set for the working directory "my/working/directory":
		resourceSet = new HenshinResourceSet(basedir);
		
		// If static meta-models are involved, initialize the relevant packages:
		metamodel.eClass();
		
		// Register relevant resource factories for model loading (XMIResourceFactoryImpl usually works): 
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		
		// Load the Henshin module:
		module = resourceSet.getModule(generatorsFilepath);
		
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
		
		for (Unit unit : module.getUnits()) {
			for (String featureName : features) {
				FeatureModel fmCopy = EcoreUtil.copy(fm);
				
				// Initialize the graph:
				EGraph graph = new EGraphImpl(fmCopy);
				
				Match partialMatch = new MatchImpl((Rule) unit);
				partialMatch.setParameterValue(unit.getParameter("name"), featureName);
				
				for (Match match : engine.findMatches((Rule) unit, graph, partialMatch)) {
					//System.out.println(match);
					// Load feature model
					FeatureModel m = EcoreUtil.copy(fmCopy);
					FeatureModel newModel = applyGenerator(match.getUnit(), m, featureName);
					fms.add(newModel);
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
		return completeFMs;
	}
	
	public FeatureModel applyGenerator(Unit generator, FeatureModel fm, String featureName) {
		// Initialize the graph:
		EGraph graph = new EGraphImpl(fm);
					
		UnitApplication application = new UnitApplicationImpl(engine, graph, generator, null);
		application.setParameterValue("name", featureName);
		application.execute(null);
		
		return fm;
	}
	
	private boolean containsAllFeatures(FeatureModel fm, List<String> features) {
		for (String name : features) {
			if (!fm.getFeatures().stream().anyMatch(f -> f.getName().equals(name))) {
				return false;
			}
		}
		return true;
	}
}
