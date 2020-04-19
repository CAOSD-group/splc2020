package uma.caosd.rhea.fms.generators.tests;

import java.io.IOException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Engine;
import org.eclipse.emf.henshin.interpreter.UnitApplication;
import org.eclipse.emf.henshin.interpreter.impl.EGraphImpl;
import org.eclipse.emf.henshin.interpreter.impl.EngineImpl;
import org.eclipse.emf.henshin.interpreter.impl.UnitApplicationImpl;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Unit;
import org.eclipse.emf.henshin.model.resource.HenshinResourceSet;

import uma.caosd.rhea.BasicFMmetamodel.BasicFMmetamodelPackage;
import uma.caosd.rhea.fms.utils.EMFIO;

public class BasicTransformationTest {

	public static void main(String[] args) throws IOException {
		// Create a resource set for the working directory "my/working/directory":
		HenshinResourceSet resourceSet = new HenshinResourceSet("src/test/resources/BasicFMs/");
		 
		// If static meta-models are involved, initialize the relevant packages:
		//BasicFMmetamodelPackage.eINSTANCE.eClass();
		//resourceSet.getPackageRegistry().put(BasicFMmetamodelPackage.eINSTANCE.getNsURI(), BasicFMmetamodelPackage.eINSTANCE);
		// Load metamodel
		EPackage metamodel = (EPackage) EMFIO.loadMetamodel("src/test/resources/BasicFMs/BasicFMmetamodel.ecore");
		resourceSet.getPackageRegistry().put(metamodel.getNsURI(), metamodel);
		
		// Load the expected model
		EObject model = EMFIO.loadModel(metamodel, "src/test/resources/BasicFMs/fms/fm_OrGroupGen_copy.xmi");
		 
		// Register relevant resource factories for model loading (XMIResourceFactoryImpl usually works): 
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		 
		// Load a model:
		//Resource model = resourceSet.getResource("fms/fm_OrGroupGen_copy.xmi");
		 
		// Load the Henshin module:
		Module module = resourceSet.getModule("generators/OrGroupGen.henshin");
		 
		/** Apply the transformation **/
		// Prepare the engine:
		Engine engine = new EngineImpl();
		 
		// Initialize the graph:
		EGraph graph = new EGraphImpl(model);
		 
		// Find the unit to be applied:
		Unit unit = module.getUnit("OrGroupGen");
		 
		// Apply the unit:
		UnitApplication application = new UnitApplicationImpl(engine, graph, unit, null);
		application.execute(null);
		
		/*****************************/
		
		// Save the model:
		EMFIO.saveModel(model, metamodel, "src/test/resources/BasicFMs/fms/fm_OrGroupGen_copy_transformed.xmi");
		//model.save(null);

	}

}
