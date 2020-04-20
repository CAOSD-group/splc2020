package uma.caosd.rhea.modularmetamodel.henshin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import uma.caosd.rhea.BasicFMmetamodel.BasicFMmetamodelPackage;
import uma.caosd.rhea.BasicFMmetamodel.FeatureModel;
import uma.caosd.rhea.modularmetamodel.utils.EMFIO;

public class StaticVSDynamic {
	public static final String BASE_DIR = "src/main/resources/models/BasicFMs/";
	
//	@Test
//	public void dynamicHenshin() throws IOException {
//		// Load metamodel
//		EPackage metamodel = loadMetamodelDynamic();
//		
//		// Create a dyanmic model
//		EObject model = createModelInstanceDynamic(metamodel);
//		
//		// Store model
//		saveModelInstance(model, metamodel, BASE_DIR + "fms/fm_instance.xmi");
//		
//		// Test henshin
//		HenshinHelper henshin = new HenshinHelper(BASE_DIR);
//		henshin.registerMetamodel(metamodel);
//		Map<String, String> parameters = Map.of("name", "Root");
//		List<EObject> modelsTransformed = henshin.executeRuleForAllMatches("RootGen.henshin", "RootFeatureGen", parameters, model);
//		System.out.println(modelsTransformed.size());
//		
//		int i = 1;
//		for (EObject o : modelsTransformed) {
//			saveModelInstance(o, metamodel, BASE_DIR + "fms/fm_instance_transformed" + i + ".xmi");
//			i++;
//		}
//		System.out.println("Done!");
//	}
	
	@Test
	public void dynamicHenshin() throws IOException {
		// Load metamodel
		EPackage metamodel = loadMetamodelDynamic();
		
		// Create a dyanmic model
		EObject model = createModelInstanceDynamic(metamodel);
		
		// Store model
		saveModelInstance(model, metamodel, BASE_DIR + "fms/fm_instance.xmi");
		
		// Test henshin
		HenshinHelper henshin = new HenshinHelper(BASE_DIR);
		//henshin.registerMetamodel(metamodel);
		Map<String, String> parameters = Map.of("name", "Root");
		List<EObject> modelsTransformed = henshin.executeRuleForAllMatches("RootGen.henshin", "RootFeatureGen", parameters, model);
		System.out.println(modelsTransformed.size());
		
		int i = 1;
		for (EObject o : modelsTransformed) {
			saveModelInstance(o, metamodel, BASE_DIR + "fms/fm_instance_transformed" + i + ".xmi");
			i++;
		}
		System.out.println("Done!");
	}
	
	private EPackage loadMetamodelStatic() {
		return BasicFMmetamodelPackage.eINSTANCE;
	}
	
	private EPackage loadMetamodelDynamic() {
		return (EPackage) EMFIO.loadMetamodel(null, BASE_DIR + "BasicFMsmetamodel.ecore");
	}
	
	private EObject createModelInstanceDynamic(EPackage metamodel) {
		EFactory mFactory = metamodel.getEFactoryInstance();
		EClass eClass = (EClass) metamodel.getEClassifier("FeatureModel");
		EObject model = mFactory.create(eClass);
		EAttribute eAttributeName = (EAttribute) eClass.getEStructuralFeature("name");
		model.eSet(eAttributeName, "fm");
		return model;
	}
	
	private void saveModelInstance(EObject model, EPackage metamodel, String path) {
		try {
			EMFIO.saveModel(null, model, metamodel, path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

