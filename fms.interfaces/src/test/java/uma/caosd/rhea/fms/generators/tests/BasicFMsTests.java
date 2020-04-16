package uma.caosd.rhea.fms.generators.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import uma.caosd.rhea.BasicFMmetamodel.BasicFMmetamodelPackage;
import uma.caosd.rhea.BasicFMmetamodel.FeatureModel;
import uma.caosd.rhea.fms.utils.EMFIO;
import uma.caosd.rhea.fms.utils.HenshinHelper;

public class BasicFMsTests {
	public static final EPackage METAMODEL = BasicFMmetamodelPackage.eINSTANCE;
	public static final String BASE_DIR = "src/test/resources/BasicFMs/";
	public static final String MODELS = BASE_DIR + "fms/";
	public static final String EXPECTED_MODELS = BASE_DIR + "expected/";
	public static final String GENERATED_MODELS = BASE_DIR + "generated/";
	
	public static final String METAMODEL_FILEPATH = BASE_DIR + "BasicFMmetamodel.ecore";
	public static final String GENERATORS_PATH = "BasicFMgenerators.henshin"; 
	
	
	/**
	 * Test the empty generator.
	 * @throws IOException 
	 */
	@Test
	public void emptyFeatureModelDynamic() throws IOException {
		String featureModelName = "fm";
		String fmFilepath = GENERATED_MODELS + "fm_dynamic.xmi";
		String fmExpectedFilepath = EXPECTED_MODELS + "fm.xmi";
		//String metamodelFilepath = BASE_DIR + "BasicFMmetamodel.ecore";
		
		// Load metamodel
		EPackage metamodel = (EPackage) EMFIO.loadMetamodel(METAMODEL_FILEPATH);
		
		EFactory mFactory = metamodel.getEFactoryInstance();
		// Create dynamic feature model
		EClass eclass = (EClass) metamodel.getEClassifier("FeatureModel");
		EObject fm = mFactory.create(eclass);
		// Get dynamic attribute of the feature model: name
		EAttribute attributeName = (EAttribute) eclass.getEStructuralFeature("name");
		fm.eSet(attributeName, featureModelName);
		
		// Save the generated model
		EMFIO.saveModel(fm, metamodel, fmFilepath);
		
		// Load the expected model
		EObject fmExpected = EMFIO.loadModel(metamodel, fmExpectedFilepath);
		
		// Compare model
		Assertions.assertTrue(EcoreUtil.equals(fm, fmExpected));
	}
	
	/**
	 * Test the empty generator.
	 * @throws IOException 
	 */
	@Test
	public void emptyFeatureModelStatic() throws IOException {
		String featureModelName = "fm";
		String fmFilepath = GENERATED_MODELS + "fm_static.xmi";
		String fmExpectedFilepath = EXPECTED_MODELS + "fm.xmi";
		//String metamodelFilepath = BASE_DIR + "BasicFMmetamodel.ecore";
		
		EPackage metamodel = METAMODEL;
		EFactory mFactory = metamodel.getEFactoryInstance();
		// Create dynamic feature model
		
		EClass eclass = (EClass) metamodel.getEClassifier("FeatureModel");
		FeatureModel fm = (FeatureModel) mFactory.create(eclass);
		fm.setName(featureModelName);
		
		// Save the generated model
		EMFIO.saveModel(fm, metamodel, fmFilepath);
		
		// Load the expected model
		FeatureModel fmExpected = (FeatureModel) EMFIO.loadModel(metamodel, fmExpectedFilepath);
		
		// Compare model
		Assertions.assertTrue(EcoreUtil.equals(fm, fmExpected));
	}
	
	/**
	 * Test the RootGen generator.
	 */
	@Test
	public void rootGen() {
		String featureName = "Root";
		String fmFilepath = "fms/fm.xmi";
		String fmExpectedFilepath = EXPECTED_MODELS + "fm_RootGen.xmi";
		
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("name", featureName);
		
		HenshinHelper henshin = new HenshinHelper(BASE_DIR);
		List<EObject> fms = henshin.executeRuleForAllMatches(GENERATORS_PATH, "RootGen", parameters, fmFilepath);
		
		// Load expected feature model
		EObject fmExpected = EMFIO.loadModel(METAMODEL, fmExpectedFilepath);
		
		Assertions.assertTrue(EcoreUtil.equals(fms.get(0), fmExpected));
	}
	
	/**
	 * Test the double application of the RootGen generator.
	 */
	@Test
	public void rootGen2() {
		String featureName = "Root";
		String fmFilepath = "fms/fm_RootGen.xmi";
		
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("name", featureName);
		
		HenshinHelper henshin = new HenshinHelper(BASE_DIR);
		List<EObject> fms = henshin.executeRuleForAllMatches(GENERATORS_PATH, "RootGen", parameters, fmFilepath);
		
		Assertions.assertTrue(fms.isEmpty());
	}
	
	/**
	 * Test the MandatoryFeatureGen over the root.
	 */
	@Test
	public void mandatoryFeatureGenA() {
		String featureName = "A";
		String fmFilepath = "fms/fm_RootGen.xmi";
		String fmExpectedFilepath = EXPECTED_MODELS + "fm_MandatoryFeatureGen_A.xmi";
		
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("name", featureName);
		
		HenshinHelper henshin = new HenshinHelper(BASE_DIR);
		List<EObject> fms = henshin.executeRuleForAllMatches(GENERATORS_PATH, "MandatoryFeatureGen", parameters, fmFilepath);
		
		// Load feature models
		FeatureModel fmExpected = (FeatureModel) EMFIO.loadModel(METAMODEL, fmExpectedFilepath);	
				
		Assertions.assertTrue(EcoreUtil.equals(fms.get(0), fmExpected));
	}
	
	/**
	 * Test the double application of MandatoryFeatureGen.
	 */
	@Test
	public void mandatoryFeatureGenA2() {
		String featureName = "A";
		String fmFilepath = "fms/fm_MandatoryFeatureGen_A.xmi";
		
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("name", featureName);
		
		HenshinHelper henshin = new HenshinHelper(BASE_DIR);
		List<EObject> fms = henshin.executeRuleForAllMatches(GENERATORS_PATH, "MandatoryFeatureGen", parameters, fmFilepath);
				
		Assertions.assertTrue(fms.isEmpty());
	}
	
	
	/**
	 * Test the MandatoryFeatureGen over the root and other feature.
	 * @throws IOException 
	 */
	@Test
	public void mandatoryFeatureGenB() throws IOException {
		String featureName = "B";
		String fmFilepath = "fms/fm_MandatoryFeatureGen_A.xmi";
		String fmExpectedFilepath1 = EXPECTED_MODELS + "fm_MandatoryFeatureGen_B1.xmi";
		String fmExpectedFilepath2 = EXPECTED_MODELS + "fm_MandatoryFeatureGen_B2.xmi";
		
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("name", featureName);
		
		HenshinHelper henshin = new HenshinHelper(BASE_DIR);
		List<EObject> fms = henshin.executeRuleForAllMatches(GENERATORS_PATH, "MandatoryFeatureGen", parameters, fmFilepath);
		
		EMFIO.saveModel(fms.get(0), METAMODEL, GENERATED_MODELS + "fm_MandatoryFeatureGen_B1_1.xmi");
		EMFIO.saveModel(fms.get(1), METAMODEL, GENERATED_MODELS + "fm_MandatoryFeatureGen_B1_2.xmi");
		
		// Load feature models
		FeatureModel fmExpected1 = (FeatureModel) EMFIO.loadModel(METAMODEL, fmExpectedFilepath1);
		FeatureModel fmExpected2 = (FeatureModel) EMFIO.loadModel(METAMODEL, fmExpectedFilepath2);
			
		Assertions.assertTrue(fms.size() == 2);
		Assertions.assertFalse(EcoreUtil.equals(fms.get(0), fms.get(1)));
		Assertions.assertTrue(EcoreUtil.equals(fms.get(0), fmExpected1));
		Assertions.assertTrue(EcoreUtil.equals(fms.get(1), fmExpected2));
	}
}

