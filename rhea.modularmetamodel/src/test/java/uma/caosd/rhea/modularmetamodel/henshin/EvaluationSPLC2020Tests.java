package uma.caosd.rhea.modularmetamodel.henshin;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EPackage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import uma.caosd.rhea.BasicFMmetamodel.BasicFMmetamodelPackage;
import uma.caosd.rhea.BasicFMmetamodel.FeatureModel;
import uma.caosd.rhea.modularmetamodel.FMConfig;
import uma.caosd.rhea.modularmetamodel.FMProductLine;
import uma.caosd.rhea.modularmetamodel.LanguageExpressiveness;

public class EvaluationSPLC2020Tests {
	public static final String BASE_DIR = "src/main/resources/models/BasicFMs/";
	public static final String STATS_DIR = "src/main/resources/models/Stats/";
	public static final int RUNS = 30;
	private static final Stats STATS = new Stats(STATS_DIR + "STATS.txt");
	
	@AfterAll
	private static void clenaup() {
		STATS.close();
	}
	
	@TestFactory
	List<DynamicTest> testRootGen_1_1() {
		String basedir = BASE_DIR;
		List<String> dynamicMetamodels = List.of("BasicFMsmetamodel.ecore");
		List<EPackage> staticMetamodels = List.of(BasicFMmetamodelPackage.eINSTANCE);
		List<String> generators = List.of("RootGen.henshin");
		int nFeatures = 1;
		int nConcreteFeatures = 1;
		String statsFilepath = STATS_DIR + "results_" + Thread.currentThread().getStackTrace()[1].getMethodName() + ".txt";
		
		List<FeatureModel> fms = launch(basedir, dynamicMetamodels, staticMetamodels, generators, nFeatures, nConcreteFeatures, statsFilepath);
		 
		return generateTest(fms, 1);
	}
	
	@TestFactory
	List<DynamicTest> testFeatureGen_2_2() {
		String basedir = BASE_DIR;
		List<String> dynamicMetamodels = List.of("BasicFMsmetamodel.ecore");
		List<EPackage> staticMetamodels = List.of(BasicFMmetamodelPackage.eINSTANCE);
		List<String> generators = List.of("RootGen.henshin", "FeatureGen.henshin");
		int nFeatures = 2;
		int nConcreteFeatures = 2;
		String statsFilepath = STATS_DIR + "results_" + Thread.currentThread().getStackTrace()[1].getMethodName() + ".txt";
		
		List<FeatureModel> fms = launch(basedir, dynamicMetamodels, staticMetamodels, generators, nFeatures, nConcreteFeatures, statsFilepath);
		 
		return generateTest(fms, 4);
	}
	
	@TestFactory
	List<DynamicTest> testFeatureGen_3_2() {
		String basedir = BASE_DIR;
		List<String> dynamicMetamodels = List.of("BasicFMsmetamodel.ecore");
		List<EPackage> staticMetamodels = List.of(BasicFMmetamodelPackage.eINSTANCE);
		List<String> generators = List.of("RootGen.henshin", "FeatureGen.henshin");
		int nFeatures = 3;
		int nConcreteFeatures = 2;
		String statsFilepath = STATS_DIR + "results_" + Thread.currentThread().getStackTrace()[1].getMethodName() + ".txt";
		
		List<FeatureModel> fms = launch(basedir, dynamicMetamodels, staticMetamodels, generators, nFeatures, nConcreteFeatures, statsFilepath);
		 
		return generateTest(fms, 11);
	}
	
	@TestFactory
	List<DynamicTest> testFeatureGen_4_2() {
		String basedir = BASE_DIR;
		List<String> dynamicMetamodels = List.of("BasicFMsmetamodel.ecore");
		List<EPackage> staticMetamodels = List.of(BasicFMmetamodelPackage.eINSTANCE);
		List<String> generators = List.of("RootGen.henshin", "FeatureGen.henshin");
		int nFeatures = 4;
		int nConcreteFeatures = 2;
		String statsFilepath = STATS_DIR + "results_" + Thread.currentThread().getStackTrace()[1].getMethodName() + ".txt";
		
		List<FeatureModel> fms = launch(basedir, dynamicMetamodels, staticMetamodels, generators, nFeatures, nConcreteFeatures, statsFilepath);
		 
		return generateTest(fms, 11);
	}
	
	
	/*******************************************************************************************************************************************************************/
	/**
	 * Return the execution time of N runs. Map of: run -> execution time in nanoseconds.				
	 */
	private Map<Integer, Long> executionTime_FMGeneration(String basedir, List<String> dynamicMetamodels, List<EPackage> staticMetamodels, List<String> generators, int nFeatures, int nConcreteFeatures) {
		LanguageExpressiveness le = new LanguageExpressiveness(basedir, dynamicMetamodels, staticMetamodels, generators, nFeatures, nConcreteFeatures);
		List<String> features = le.getFeatures();
		
		Map<Integer, Long> times = new HashMap<Integer, Long>();
		for (int i = 1; i <= RUNS; i++) {
			long start = System.nanoTime();
			FeatureModelGenerator fmGen = new FeatureModelGenerator(basedir, dynamicMetamodels, staticMetamodels, generators);
			List<FeatureModel> fms = fmGen.generateAllFeatureModels("fm", features);
			long end = System.nanoTime();
			
			times.put(i, end-start);
		}
		return times;
	}
	
	private List<FeatureModel> getFMs(String basedir, List<String> dynamicMetamodels, List<EPackage> staticMetamodels, List<String> generators, int nFeatures, int nConcreteFeatures) {
		LanguageExpressiveness le = new LanguageExpressiveness(basedir, dynamicMetamodels, staticMetamodels, generators, nFeatures, nConcreteFeatures);
		return le.getFeatureModels();
	}
	
	private List<FeatureModel> launch(String basedir, List<String> dynamicMetamodels, List<EPackage> staticMetamodels, List<String> generators, int nFeatures, int nConcreteFeatures, String statsFilepath) {
		long start, timeConfigs, timeSPLs, timeSPLsCovered;
		//List<FeatureModel> fms = getFMs(basedir, dynamicMetamodels, staticMetamodels, generators, nFeatures, nConcreteFeatures);
		Map<Integer, Long> times = executionTime_FMGeneration(basedir, dynamicMetamodels, staticMetamodels, generators, nFeatures, nConcreteFeatures);
			
		LanguageExpressiveness le = new LanguageExpressiveness(basedir, dynamicMetamodels, staticMetamodels, generators, nFeatures, nConcreteFeatures);
		
		PrintWriter out = null;
		try {
			out = new PrintWriter(new BufferedWriter(new FileWriter(statsFilepath)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
        out.println("********** METAMODELS AND LANGUAGE CONSTRUCTS **********");
        out.println("Metamodels: " + dynamicMetamodels);
        out.println("Language constructs: " + generators);
        
        out.println();
        out.println("********** FEATURES **********");
		out.println("#F: " + le.getFeatures().size());
		out.println(le.getFeatures());
		
		out.println();
		out.println("********** CONCRETE FEATURES **********");
		out.println("#P: " + le.getConcreteFeatures().size());
		out.println(le.getConcreteFeatures());
		
		out.println();
		out.println("********** ALL POSSIBLE CONFIGURATIONS **********");
		start = System.nanoTime();
		Set<FMConfig> configs = LanguageExpressiveness.getAllPossibleConfigurations(le.getConcreteFeatures());
		timeConfigs = System.nanoTime() - start;
		out.println("#Power(P): " + configs.size());
		out.println(configs);
		
		
		out.println();
		out.println("********** ALL POSSIBLE PRODUCT LINES **********");
		start = System.nanoTime();
		Set<FMProductLine> pls = LanguageExpressiveness.getAllPossibleProductLines(le.getConcreteFeatures());
		timeSPLs = System.nanoTime() - start;
		out.println("#Power(Power(P)): " + pls.size());
		out.println(pls);
		
		out.println();
		out.println("********** ALL POSSIBLE FEATURE MODELS IN L (i.e., can be specified by these metamodels) **********");
		List<FeatureModel> fms = le.getFeatureModels();
		System.out.println("#FMs: " + fms.size());
		out.println("#FMs: " + fms.size());
		/*
		for (FeatureModel fm : fms) {
			EMFIO.saveModel(fm, metamodel, TEMPORAL_FILES + fm.getName() + ".xmi");
		}
		*/
		if (fms.size() <= 10000) {
			out.println();
			out.println("********** MAPPING: FM -> CONFIGS -> SPL **********");
			System.out.println("Generating Configurations...");
			start = System.nanoTime();
			var fmConfigs = le.getConfigurations();
			timeSPLsCovered = System.nanoTime() - start;
			var fmMapping = le.getMappingFunction();
			for (FeatureModel fm : fms) {
				out.println(fm.getName() + " (" + fmConfigs.get(fm).size() + " configs) -> " + fmConfigs.get(fm) + " -> " + fmMapping.get(fm));
			}
			
			out.println();
			out.println("********** ALL DISTINCT SPLS COVERED BY FEATURE MODELS IN L **********");
			System.out.println("Generating SPLs...");
			Set<FMProductLine> spls = le.getProductLines();
			out.println("#SPLs: " + spls.size());
			for (FMProductLine pl : spls) {
				out.println("SPL: " + pl);
			}

			out.println();
			out.println("********** STATS **********");
			out.println("#SPLs covered by FMs in L: " + spls.size() + "/" + pls.size() + " (" + (double)(spls.size())/pls.size() * 100 + "%)");
			
			STATS.addStats(RUNS, 
					   fms.size(), 
					   dynamicMetamodels, 
					   generators, 
					   nFeatures, 
					   nConcreteFeatures, 
					   configs.size(), 
					   timeConfigs, 
					   pls.size(), 
					   timeSPLs, 
					   spls.size(), 
					   timeSPLsCovered, 
					   times.values());
		} else {
			STATS.addStats(RUNS, 
					   fms.size(), 
					   dynamicMetamodels, 
					   generators, 
					   nFeatures, 
					   nConcreteFeatures, 
					   configs.size(), 
					   timeConfigs, 
					   pls.size(), 
					   timeSPLs,
					   times.values());
		}
		out.close();
		System.out.println("Done!");

		return fms;
	}
	
	private List<DynamicTest> generateTest(List<FeatureModel> fms, int expectedFMs) {
		List<DynamicTest> tests = new ArrayList<DynamicTest>();
		
		// Correct numbers of feature models generated
		tests.add(DynamicTest.dynamicTest("Number of FMs", () -> Assertions.assertTrue(fms.size() == expectedFMs)));
		
		return tests;
	}
}
