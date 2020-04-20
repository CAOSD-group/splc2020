package uma.caosd.rhea.modularmetamodel.henshin;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import uma.caosd.rhea.BasicConstraints.BasicConstraintsPackage;
import uma.caosd.rhea.BasicFMmetamodel.BasicFMmetamodelPackage;
import uma.caosd.rhea.BasicFMmetamodel.FeatureModel;
import uma.caosd.rhea.modularmetamodel.utils.EMFIO;

public class TestHenshinHelperDefinitive {

	public static void main(String[] args) throws IOException {
		// Base working dir
		String basedir = "src/main/resources/models/BasicFMs/";
		
		
		// Initialize Henshin
		HenshinHelper henshin = new HenshinHelper(basedir);
		
		
		// Load and register the metamodel
		EPackage metamodel = henshin.registerMetamodel("BasicFMsmetamodel.ecore");
		henshin.registerMetamodel("BasicConstraints.ecore");
		
		
		// Load the instance model
		//EObject model = henshin.loadModel("fms/fm_dynamicInstance.xmi");
		//EObject model = henshin.loadModel("fms/fm_dynamicInstance_constraints.xmi");
		
		
		// Create the instance model from scratch
//		EPackage metamodel = (EPackage) EMFIO.loadMetamodel(null, basedir + "BasicFMsmetamodel.ecore");
//		EFactory mFactory = metamodel.getEFactoryInstance();
//		EClass eClass = (EClass) metamodel.getEClassifier("FeatureModel");
//		EObject model = mFactory.create(eClass);
//		EAttribute eAttributeName = (EAttribute) eClass.getEStructuralFeature("name");
//		model.eSet(eAttributeName, "fm");
		
		
		// Create the instance model from scratch using static and loadling dynamically.
		FeatureModel fm = BasicFMmetamodelPackage.eINSTANCE.getBasicFMmetamodelFactory().createFeatureModel();
		fm.setName("fm2");
		EMFIO.saveModel(fm, List.of(BasicFMmetamodelPackage.eINSTANCE, BasicConstraintsPackage.eINSTANCE), basedir + "fms/fm_staticInstance.xmi");
		EObject model = henshin.loadModel("fms/fm_staticInstance.xmi");
		
		
		// Apply the rule 
		Map<String, String> parameters = Map.of("name", "Root");
		//Map<String, String> parameters = Map.of();
		List<EObject> modelsTransformed = henshin.executeRuleForAllMatches("RootGen.henshin", "RootFeatureGen", parameters, model);
		//List<EObject> modelsTransformed = henshin.executeRuleForAllMatches("BasicConstraintsGen.henshin", "RequiresGen", parameters, model);
		System.out.println(modelsTransformed.size());
		
		
		// Store transformed models
		int i = 1;
		for (EObject o : modelsTransformed) {
			henshin.saveModel(o, "fms/fm_dynamicInstance_transformed" + i + ".xmi");
			//henshin.saveModel(o, "fms/fm_dynamicInstance_constraints_transformed" + i + ".xmi");
			i++;
		}

		// Load as a feature model
		/*EObject objectLoaded = EMFIO.loadModel(null, BasicFMmetamodelPackage.eINSTANCE, basedir + "fms/fm_dynamicInstance_constraints_transformed" + 1 + ".xmi");
		FeatureModel fm = (FeatureModel) objectLoaded;
		System.out.println(fm.getCrossTreeConstraints());
		EMFIO.saveModel(fm, BasicFMmetamodelPackage.eINSTANCE, basedir + "fms/fm_dynamicInstance_constraints_transformed" + 1 + "v2.xmi");
		*/
		System.out.println("Done!");
	}
}
