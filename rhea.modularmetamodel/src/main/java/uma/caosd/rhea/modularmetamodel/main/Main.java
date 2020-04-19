package uma.caosd.rhea.modularmetamodel.main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

import uma.caosd.rhea.BasicFMmetamodel.FeatureModel;
import uma.caosd.rhea.modularmetamodel.FMConfig;
import uma.caosd.rhea.modularmetamodel.FMProductLine;
import uma.caosd.rhea.modularmetamodel.LanguageExpressiveness;
import uma.caosd.rhea.modularmetamodel.henshin.FeatureModelGenerator;

public class Main {
	public static final String BASE_DIR = "src/main/resources/models/BasicFMs/";
	public static final List<String> METAMODELS_PATHS = List.of("BasicFMsmetamodel.ecore");
	public static final List<String> GENERATORS_PATHS = List.of("RootGen.henshin", "OptionalFeatureGen.henshin", "MandatoryFeatureGen.henshin");

	public static final int N_FEATURES = 2;
	public static final int CONCRETE_FEATURES = 2;
	
	public static final String TEMPORAL_FILES = BASE_DIR + "temp/";
	
	public static void main(String[] args) throws IOException {
		
		FeatureModelGenerator fmGen = new FeatureModelGenerator(BASE_DIR, METAMODELS_PATHS, GENERATORS_PATHS);
		//fmGen.generateAllFeatureModels(prefixName, features)
		
		LanguageExpressiveness le = new LanguageExpressiveness(BASE_DIR, METAMODELS_PATHS, GENERATORS_PATHS, N_FEATURES, CONCRETE_FEATURES);
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("src/main/resources/models/stats.txt")));
		
        out.println("********** METAMODELS AND LANGUAGE CONSTRUCTS **********");
        out.println("Metamodels: " + METAMODELS_PATHS);
        out.println("Language constructs: " + GENERATORS_PATHS);
        
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
		Set<FMConfig> configs = LanguageExpressiveness.getAllPossibleConfigurations(le.getConcreteFeatures());
		out.println("#Power(P): " + configs.size());
		out.println(configs);
		
		out.println();
		out.println("********** ALL POSSIBLE PRODUCT LINES **********");
		Set<FMProductLine> pls = LanguageExpressiveness.getAllPossibleProductLines(le.getConcreteFeatures());
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
		
		out.println();
		out.println("********** MAPPING: FM -> CONFIGS -> SPL **********");
		System.out.println("Generating Configurations...");
		var fmConfigs = le.getConfigurations();
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
		
		out.close();
		
		System.out.println("Done!");
	}
}

