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
import uma.caosd.rhea.modularmetamodel.utils.EMFIO;

public class TestHenshinHelperConstraints {

	public static void main(String[] args) throws IOException {
		// Base working dir
		String basedir = "src/main/resources/models/BasicFMs/";
		
		// Load dynamic metamodel
		//EPackage metamodel = (EPackage) EMFIO.loadMetamodel(basedir + "BasicFMsmetamodel.ecore");
		//EPackage metamodel2 = (EPackage) EMFIO.loadMetamodel(basedir + "BasicConstraints.ecore");
		// Load static metamodel
		EPackage metamodel = BasicFMmetamodelPackage.eINSTANCE;
		EPackage metamodel2 = BasicConstraintsPackage.eINSTANCE;
		
		
		// Create a dyanmic model
		EFactory mFactory = metamodel.getEFactoryInstance();
		EClass eClass = (EClass) metamodel.getEClassifier("FeatureModel");
		EObject model = mFactory.create(eClass);
		EAttribute eAttributeName = (EAttribute) eClass.getEStructuralFeature("name");
		model.eSet(eAttributeName, "fm");
		
		// Store model
		try {
			EMFIO.saveModel(null, model, metamodel, basedir + "fms/fm.xmi");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Load again the model
		EObject modelLoaded = EMFIO.loadModel(null, metamodel, basedir + "fms/fm_constraints_test.xmi");
		//FeatureModel fm = (FeatureModel) modelLoaded;
		//System.out.println(fm.getName());
		
		
		HenshinHelper henshin = new HenshinHelper(basedir);
		henshin.registerMetamodel(metamodel);
		henshin.registerMetamodel(metamodel2);
		Map<String, String> parameters = Map.of();
		List<EObject> modelsTransformed = henshin.executeRuleForAllMatches("BasicConstraintsGen.henshin", "RequiresGen", parameters, modelLoaded);
		//List<EObject> modelsTransformed = henshin.executeRuleForAllMatches("RootGen.henshin", "RootFeatureGen", parameters, "fms/fm.xmi");
		System.out.println(modelsTransformed.size());
		int i = 1;
		for (EObject o : modelsTransformed) {
			EMFIO.saveModel(null, o, metamodel2, "fms/fm_constraints_test_transformed" + i + ".xmi");
			//henshin.saveModel(o, "fms/fm_constraints_test_transformed" + i + ".xmi");
			i++;
		}
		
		System.out.println("Done!");
	}
}
