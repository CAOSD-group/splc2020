package uma.caosd.rhea.fms.generators.tests;

import java.io.IOException;
import java.util.ArrayList;
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
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import uma.caosd.rhea.BasicFMmetamodel.BasicFMmetamodelPackage;
import uma.caosd.rhea.BasicFMmetamodel.FeatureModel;
import uma.caosd.rhea.fms.utils.EMFIO;
import uma.caosd.rhea.fms.utils.HenshinHelper;

public class BasicFMsTests {
	public static final EPackage METAMODEL = BasicFMmetamodelPackage.eINSTANCE;
	public static final String BASE_DIR = "src/test/resources/BasicFMs/";
	public static final String FMS_PATH = BASE_DIR + "fms/";
	public static final String EXPECTED_FMS_PATH = BASE_DIR + "expected/";
	public static final String GENERATED_MODELS = BASE_DIR + "generated/";
	
	public static final String FMS_DIR = "fms/";
	public static final String EXPECTED_FMS_DIR = "expected/";
	
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
		String fmExpectedFilepath = EXPECTED_FMS_PATH + "fm.xmi";
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
		String fmExpectedFilepath = EXPECTED_FMS_PATH + "fm.xmi";
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
	
	@TestFactory
	List<DynamicTest> testGenerationFMs_RootGen() {
		List<String> expectedFMs = List.of("fm_RootGen.xmi");
		String generatorName = "RootGen";
		String featureName = "Root";
		String sourceFM = "fm.xmi";
	
		List<DynamicTest> tests = genDynamicTestsForGeneratorApplication(expectedFMs, generatorName, featureName, sourceFM);
		tests.addAll(genDynamicTestForGeneratorApplicationWithoutResults(generatorName, featureName, expectedFMs));
		return tests;
	}
	
	@TestFactory
	List<DynamicTest> testGenerationFMs_MandatoryFeatureA() {
		List<String> expectedFMs = List.of("fm_MandatoryFeatureGen_A.xmi");
		String generatorName = "MandatoryFeatureGen";
		String featureName = "A";
		String sourceFM = "fm_RootGen.xmi";
	
		List<DynamicTest> tests = genDynamicTestsForGeneratorApplication(expectedFMs, generatorName, featureName, sourceFM);
		tests.addAll(genDynamicTestForGeneratorApplicationWithoutResults(generatorName, featureName, expectedFMs));
		return tests;
	}
	
	@TestFactory
	List<DynamicTest> testGenerationFMs_MandatoryFeatureB() {
		List<String> expectedFMs = List.of("fm_MandatoryFeatureGen_B1.xmi", "fm_MandatoryFeatureGen_B2.xmi");
		String generatorName = "MandatoryFeatureGen";
		String featureName = "B";
		String sourceFM = "fm_MandatoryFeatureGen_A.xmi";
	
		List<DynamicTest> tests = genDynamicTestsForGeneratorApplication(expectedFMs, generatorName, featureName, sourceFM);
		tests.addAll(genDynamicTestForGeneratorApplicationWithoutResults(generatorName, featureName, expectedFMs));
		return tests;
	}
	
	@TestFactory
	List<DynamicTest> testGenerationFMs_OptionalFeatureA() {
		List<String> expectedFMs = List.of("fm_OptionalFeatureGen_A.xmi");
		String generatorName = "OptionalFeatureGen";
		String featureName = "A";
		String sourceFM = "fm_RootGen.xmi";
	
		List<DynamicTest> tests = genDynamicTestsForGeneratorApplication(expectedFMs, generatorName, featureName, sourceFM);
		tests.addAll(genDynamicTestForGeneratorApplicationWithoutResults(generatorName, featureName, expectedFMs));
		return tests;
	}
	
	@TestFactory
	List<DynamicTest> testGenerationFMs_OptionalFeatureB() {
		List<String> expectedFMs = List.of("fm_OptionalFeatureGen_B1.xmi", "fm_OptionalFeatureGen_B2.xmi");
		String generatorName = "OptionalFeatureGen";
		String featureName = "B";
		String sourceFM = "fm_MandatoryFeatureGen_A.xmi";
	
		List<DynamicTest> tests = genDynamicTestsForGeneratorApplication(expectedFMs, generatorName, featureName, sourceFM);
		tests.addAll(genDynamicTestForGeneratorApplicationWithoutResults(generatorName, featureName, expectedFMs));
		return tests;
	}
	
	/**
	 * Generate dynamic tests for the application of the generators for language constructs.
	 * 
	 * @param expectedFMs
	 * @param generator
	 * @param featureName
	 * @param sourceFM
	 * @return
	 */
	private List<DynamicTest> genDynamicTestsForGeneratorApplication(List<String> expectedFMs, String generator, String featureName, String sourceFM) {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("name", featureName);
		
		HenshinHelper henshin = new HenshinHelper(BASE_DIR);
		List<EObject> resultFMs = henshin.executeRuleForAllMatches(GENERATORS_PATH, generator, parameters, FMS_DIR + sourceFM);
		
		List<FeatureModel> expectedFMsLoaded = new ArrayList<FeatureModel>();
		for (String filepath : expectedFMs) {
			expectedFMsLoaded.add((FeatureModel) EMFIO.loadModel(METAMODEL, EXPECTED_FMS_PATH + filepath));
		}
		
		// The tests
		List<DynamicTest> list = new ArrayList<DynamicTest>();
		
		// Correct numbers of feature models generated
		list.add(DynamicTest.dynamicTest("Number of FMs", () -> Assertions.assertTrue(resultFMs.size() == expectedFMs.size())));
		
		// All feature models are distinct
		list.add(DynamicTest.dynamicTest("Distinct FMs", () -> Assertions.assertTrue(resultFMs.stream().allMatch(fm -> (resultFMs.stream().filter(fm2 -> !fm.equals(fm2)).count()) == resultFMs.size()-1))));
		
		// All feature models are the expected one
		for (FeatureModel fm : expectedFMsLoaded) {
			list.add(DynamicTest.dynamicTest("Expected FM " + fm.eResource(), () -> Assertions.assertTrue(resultFMs.stream().anyMatch(fm2 -> EcoreUtil.equals(fm, fm2)))));
		}
		//list.add(DynamicTest.dynamicTest("Expected FMs", () -> Assertions.assertTrue(resultFMs.stream().allMatch(fm -> (expectedFMsLoaded.stream().anyMatch(fm2 -> EcoreUtil.equals(fm, fm2)))))));
		
		return list;
	}
	
	/**
	 * Generate dynamic tests for the double (incorrect) application of the generators.
	 * 
	 * @param generator
	 * @param featureName
	 * @param sourceFMs
	 * @return
	 */
	private List<DynamicTest> genDynamicTestForGeneratorApplicationWithoutResults(String generator, String featureName, List<String> sourceFMs) {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("name", featureName);
		
		HenshinHelper henshin = new HenshinHelper(BASE_DIR);
		
		// The tests
		List<DynamicTest> list = new ArrayList<DynamicTest>();
		for (String filepath : sourceFMs) {
			List<EObject> resultFMs = henshin.executeRuleForAllMatches(GENERATORS_PATH, generator, parameters, FMS_DIR + filepath);
			list.add(DynamicTest.dynamicTest("Double application in FM " + filepath, () -> Assertions.assertTrue(resultFMs.isEmpty())));
		}
		return list;
	}
}

