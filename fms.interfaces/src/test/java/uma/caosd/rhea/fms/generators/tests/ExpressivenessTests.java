package uma.caosd.rhea.fms.generators.tests;

import java.io.IOException;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Engine;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.interpreter.RuleApplication;
import org.eclipse.emf.henshin.interpreter.UnitApplication;
import org.eclipse.emf.henshin.interpreter.impl.EGraphImpl;
import org.eclipse.emf.henshin.interpreter.impl.EngineImpl;
import org.eclipse.emf.henshin.interpreter.impl.MatchImpl;
import org.eclipse.emf.henshin.interpreter.impl.UnitApplicationImpl;
import org.eclipse.emf.henshin.interpreter.util.InterpreterUtil;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.Unit;
import org.eclipse.emf.henshin.model.resource.HenshinResourceSet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import uma.caosd.rhea.BasicFMmetamodel.BasicFMmetamodelPackage;
import uma.caosd.rhea.BasicFMmetamodel.FeatureModel;
import uma.caosd.rhea.fms.generators.Expressiveness_Old;
import uma.caosd.rhea.fms.utils.EMFIO;

public class ExpressivenessTests {

	
	@Test
	public void subsetPTest() {
		int N = 36;
		List<String> genP = Expressiveness_Old.getConcreteFeatures(N);
		System.out.println(genP);
		Assertions.assertTrue(genP.size() == 36);
	}
	
	@Test
	public void generateEmptyFeatureModelTest() throws IOException {
		String metamodelFilepath = "src/main/resources/BasicFMs/BasicFMmetamodel.ecore";
		String instanceFilepath = "src/main/resources/BasicFMs/instanceGen.xmi";
		EPackage metamodel = (EPackage) EMFIO.loadMetamodel(metamodelFilepath);
		
		EObject fm = Expressiveness_Old.generateEmptyFeatureModel(metamodel);
		EMFIO.saveModel(fm, metamodel, instanceFilepath);
		
		FeatureModel fmLoaded = (FeatureModel) EMFIO.loadModel(BasicFMmetamodelPackage.eINSTANCE, instanceFilepath);
		fmLoaded.setName("fm1");
		
		System.out.println(fmLoaded);
	}
	
	@Test
	public void generateFeatureModels() throws IOException {
		// Variables
		int N = 2;																				// Number of concrete features
		String baseDir = "src/main/resources/BasicFMs/";
		String instanceFilepath = "fm1.xmi";											// Filepath for the initial empty feature model
		EPackage metamodel = BasicFMmetamodelPackage.eINSTANCE;									// Metamodel
		String generatorsFilepath = "BasicFMgenerators.henshin"; 						// Filepath of the Henshin generators
		
		// Generate set P of concrete features.
		List<String> P = Expressiveness_Old.getConcreteFeatures(N);									// Set P of concrete features
		
		// Generate initial instance of the feature model
		//EObject fmDynamicObject = Expressiveness.generateEmptyFeatureModel(metamodel);
		//EMFIO.saveModel(fmDynamicObject, metamodel, baseDir + instanceFilepath);
		
		// Load the feature model statically and start the process
		FeatureModel fm = (FeatureModel) EMFIO.loadModel(metamodel, baseDir + instanceFilepath);			// The initial empty feature model
		
		
		/************************************************** Henshin ********************************************/
		// Create a resource set for the working directory "my/working/directory":
		HenshinResourceSet resourceSet = new HenshinResourceSet(baseDir);
		
		// If static meta-models are involved, initialize the relevant packages:
		metamodel.eClass();
				 
		// Register relevant resource factories for model loading (XMIResourceFactoryImpl usually works): 
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		
		// Load a model:
		//Resource model = resourceSet.getResource(instanceFilepath);
		
		// Load the Henshin module:
		Module module = resourceSet.getModule(generatorsFilepath);
		
		// Prepare the engine:
		Engine engine = new EngineImpl();
				 
		// Initialize the graph:
		EGraph graph = new EGraphImpl(fm);
		
		List<Unit> generators = module.getUnits();
		
		System.out.println("=====================");
		for (Match match : InterpreterUtil.findAllMatches(engine, module, graph)) {
			System.out.println("Match: " + match);
			
			match.setParameterValue(match.getUnit().getParameter("name"), "A");
			InterpreterUtil.applyToResource(match.getUnit(), engine, (Resource) fm);
			EMFIO.saveModel(fm, metamodel, baseDir + "fm2.xmi");
		}
		System.out.println("=====================");
//		
//		while (!Expressiveness.containsAllFeatures(fm, P)) {
////			for (Unit unit : generators) {
////				Match partialMatch = new MatchImpl((Rule) unit);
////				partialMatch.setParameterValue(unit.getParameter("name"), "A");
////				
//				for (Match match : InterpreterUtil.findAllMatches(engine, module, graph)) {
//					System.out.println(match);
//				}
//				
//			//}
//		}
		
		// Find the unit to be applied:
		Unit unit = module.getUnit("RootGen");
		
		// Apply the unit:
		UnitApplication application = new UnitApplicationImpl(engine, graph, unit, null);
		application.setParameterValue("name", "FMroot");
		application.execute(null); 
		
		System.out.println(fm.getFeatures());
		//System.out.println(model.getClass());
		
		EMFIO.saveModel(fm, metamodel, baseDir + "fm1.xmi");
		// Save the model:
		try {
			((Resource) fm).save(null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
