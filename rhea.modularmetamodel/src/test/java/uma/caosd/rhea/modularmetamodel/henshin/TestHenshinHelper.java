package uma.caosd.rhea.modularmetamodel.henshin;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;

import uma.caosd.rhea.BasicFMmetamodel.BasicFMmetamodelFactory;
import uma.caosd.rhea.BasicFMmetamodel.BasicFMmetamodelPackage;
import uma.caosd.rhea.BasicFMmetamodel.FeatureModel;
import uma.caosd.rhea.modularmetamodel.utils.EMFIO;

public class TestHenshinHelper {

	public static void main(String[] args) throws IOException {
		// Base working dir
		String basedir = "src/main/resources/models/BasicFMs/";
		
		// Load dynamic metamodel
		//EPackage metamodel = (EPackage) EMFIO.loadMetamodel(basedir + "BasicFMsmetamodel.ecore");
		// Load static metamodel
		EPackage metamodel = BasicFMmetamodelPackage.eINSTANCE;
		
		
		// Create a dyanmic model
		EFactory mFactory = metamodel.getEFactoryInstance();
		EClass eClass = (EClass) metamodel.getEClassifier("FeatureModel");
		EObject model = mFactory.create(eClass);
		EAttribute eAttributeName = (EAttribute) eClass.getEStructuralFeature("name");
		model.eSet(eAttributeName, "fm");
		
		// Store model
		try {
			EMFIO.saveModel(model, metamodel, basedir + "fms/fm.xmi");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Load again the model
		EObject modelLoaded = EMFIO.loadModel(metamodel, basedir + "fms/fm.xmi");
		//FeatureModel fm = (FeatureModel) modelLoaded;
		//System.out.println(fm.getName());
		
		
		HenshinHelper henshin = new HenshinHelper(basedir);
		henshin.registerMetamodel(metamodel);
		Map<String, String> parameters = Map.of("name", "Root");
		List<EObject> modelsTransformed = henshin.executeRuleForAllMatches("RootGen.henshin", "RootFeatureGen", parameters, model);
		//List<EObject> modelsTransformed = henshin.executeRuleForAllMatches("RootGen.henshin", "RootFeatureGen", parameters, "fms/fm.xmi");
		System.out.println(modelsTransformed.size());
		
		System.out.println("Done!");
	}
}
