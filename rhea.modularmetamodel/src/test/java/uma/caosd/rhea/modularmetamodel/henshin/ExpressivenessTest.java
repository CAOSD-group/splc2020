package uma.caosd.rhea.modularmetamodel.henshin;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.eclipse.emf.ecore.EPackage;

import uma.caosd.rhea.BasicConstraints.BasicConstraintsPackage;
import uma.caosd.rhea.BasicFMmetamodel.BasicFMmetamodelPackage;
import uma.caosd.rhea.BasicFMmetamodel.FeatureModel;
import uma.caosd.rhea.modularmetamodel.FMConfig;
import uma.caosd.rhea.modularmetamodel.FMProductLine;
import uma.caosd.rhea.modularmetamodel.LanguageExpressiveness;

public class ExpressivenessTest {
	public static final String BASE_DIR = "src/main/resources/models/BasicFMs/";
	public static final String STATS_DIR = "src/main/resources/models/Stats/";
	public static final int RUNS = 1;
	
	public static final int FEATURES = 5;
	public static final int CONCRETE_FEATURES = 2;
	
	public static void main(String[] args) throws IOException {
//		PrintStream o = new PrintStream(new File(STATS_DIR + "output.txt")); 
//		System.setOut(o);
		
		String basedir = BASE_DIR;
		
		// M0 (BasicFMs without constraints):
		/*
		List<String> dynamicMetamodels = List.of("BasicFMsmetamodel.ecore");
		List<EPackage> staticMetamodels = List.of(BasicFMmetamodelPackage.eINSTANCE);
		List<String> generators = List.of("RootGen.henshin", "FeatureGen.henshin", "OrGroupGen.henshin", "AlternativeGen.henshin");
		*/
		
		// BasicFMs
		/*
		List<String> dynamicMetamodels = List.of("BasicFMsmetamodel.ecore", "BasicConstraints.ecore");
		List<EPackage> staticMetamodels = List.of(BasicFMmetamodelPackage.eINSTANCE, BasicConstraintsPackage.eINSTANCE);
		List<String> generators = List.of("RootGen.henshin", "FeatureGen.henshin", "OrGroupGen.henshin", "AlternativeGen.henshin", "BasicConstraintsGen.henshin");
		*/
		
		List<String> dynamicMetamodels = List.of("BasicFMsmetamodel.ecore");
		List<EPackage> staticMetamodels = List.of(BasicFMmetamodelPackage.eINSTANCE, BasicConstraintsPackage.eINSTANCE);
		List<String> generators = List.of("RootGen.henshin", "FeatureGen.henshin");
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(STATS_DIR + "resuls.txt")));
		
		
		long start, timeConfigs, timeSPLs, timeFMs, timeSPLsCovered;
			
		LanguageExpressiveness le = new LanguageExpressiveness(basedir, dynamicMetamodels, staticMetamodels, generators, FEATURES, CONCRETE_FEATURES);
		
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
		out.println("********** ALL POSSIBLE DISTINCT PRODUCT LINES **********");
		Set<FMProductLine> distinctpls = LanguageExpressiveness.getAllPossibleDistinctSPLs(le.getConcreteFeatures());
		out.println("#DistinctSPLS: " + distinctpls.size());
		out.println(distinctpls);
		long distinctPLs = LanguageExpressiveness.getNumberAllPossibleDistinctSPLs(le.getConcreteFeatures());
		out.println("#DistinctSPLs (formulae): " + distinctPLs);
		
		
		out.println();
		out.println("********** ALL POSSIBLE FEATURE MODELS IN L (i.e., can be specified by these metamodels) **********");
		start = System.nanoTime();
		List<FeatureModel> fms = le.getFeatureModels();
		timeFMs = System.nanoTime() - start;
		System.out.println("#FMs: " + fms.size());
		out.println("#FMs: " + fms.size());
		/*
		for (FeatureModel fm : fms) {
			EMFIO.saveModel(fm, metamodel, TEMPORAL_FILES + fm.getName() + ".xmi");
		}
		*/
		
		if (fms.size() > 1000) {
			out.close();
			
			// Print stats
			PrintWriter stats = new PrintWriter(new BufferedWriter(new FileWriter(STATS_DIR + "resultsTime.txt")));
			stats.println("#F, #Concrete, #FMs, Time (s), #Configs, Time (s), #SPLs, #DistinctSPLs, Time (s)");
			stats.print(FEATURES + ",");
			stats.print(CONCRETE_FEATURES + ",");
			stats.print(fms.size() + ",");
			stats.print(timeFMs*1e-9 + ",");
			stats.print(configs.size() + ",");
			stats.print(timeConfigs*1e-9 + ",");
			stats.print(pls.size() + ",");
			stats.print(distinctPLs + ",");
			stats.print(timeSPLs*1e-9 + ",");
			stats.close();
		} else {
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
			out.println("********** ALL SPLS COVERED BY FEATURE MODELS IN L **********");
			System.out.println("Generating SPLs...");
			Set<FMProductLine> spls = le.getProductLines();
			out.println("#SPLs: " + spls.size());
			for (FMProductLine pl : spls) {
				out.println("SPL: " + pl);
			}
			out.println();
			out.println("********** ALL DISTINCT SPLS COVERED BY FEATURE MODELS IN L **********");
			Set<FMProductLine> distinctspls = le.getDistinctProductLines();
			out.println("#SPLs: " + distinctspls.size());
			for (FMProductLine pl : distinctspls) {
				out.println("SPL: " + pl);
			}
			

			out.println();
			out.println("********** STATS **********");
			out.println("#SPLs covered by FMs in L: " + spls.size() + "/" + pls.size() + " (" + (double)(spls.size())/pls.size() * 100 + "%)");
			out.println("#Distinct SPLs covered by FMs in L: " + distinctspls.size() + "/" + distinctPLs + " (" + (double)(distinctspls.size())/distinctPLs * 100 + "%)");
			
			out.close();
			
			// Print stats
			PrintWriter stats = new PrintWriter(new BufferedWriter(new FileWriter(STATS_DIR + "resultsTime.txt")));
			stats.println("#F, #Concrete, #FMs, Time (s), #Configs, Time (s), #SPLs, #DistinctSPLs, Time (s), #SPLsMap, #DistinctSPLsMap, Time (s), Expr (%), Distinct Expr (%)");
			double expr = (double)(spls.size())/pls.size() * 100;
			double distinctexpr = (double)(distinctspls.size())/distinctPLs * 100;
			stats.print(FEATURES + ",");
			stats.print(CONCRETE_FEATURES + ",");
			stats.print(fms.size() + ",");
			stats.print(timeFMs*1e-9 + ",");
			stats.print(configs.size() + ",");
			stats.print(timeConfigs*1e-9 + ",");
			stats.print(pls.size() + ",");
			stats.print(distinctPLs + ",");
			stats.print(timeSPLs*1e-9 + ",");
			stats.print(spls.size() + ",");
			stats.print(distinctspls.size() + ",");
			stats.print(timeSPLsCovered*1e-9 + ",");
			stats.print(expr + ",");
			stats.println(distinctexpr);
			stats.close();
		}
		
		System.out.println("Done!");
					
	}
}
