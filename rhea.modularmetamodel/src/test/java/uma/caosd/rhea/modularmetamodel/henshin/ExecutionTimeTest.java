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

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.eclipse.emf.ecore.EPackage;

import uma.caosd.rhea.BasicConstraints.BasicConstraintsPackage;
import uma.caosd.rhea.BasicFMmetamodel.BasicFMmetamodelPackage;
import uma.caosd.rhea.BasicFMmetamodel.FeatureModel;
import uma.caosd.rhea.modularmetamodel.LanguageExpressiveness;

public class ExecutionTimeTest {
	public static final String BASE_DIR = "src/main/resources/models/BasicFMs/";
	public static final String STATS_DIR = "src/main/resources/models/Stats/";
	public static final int RUNS = 1;
	
	public static final int MAX_FEATURES = 3;
	
	public static void main(String[] args) throws IOException {
//		PrintStream o = new PrintStream(new File(STATS_DIR + "output.txt")); 
//		System.setOut(o);
		
		String basedir = BASE_DIR;
		//List<String> dynamicMetamodels = List.of("BasicFMsmetamodel.ecore", "BasicConstraints.ecore");
		List<String> dynamicMetamodels = List.of("BasicFMsmetamodel.ecore");
		//List<EPackage> staticMetamodels = List.of(BasicFMmetamodelPackage.eINSTANCE, BasicConstraintsPackage.eINSTANCE);
		List<EPackage> staticMetamodels = List.of(BasicFMmetamodelPackage.eINSTANCE);
		List<String> generators = List.of("RootGen.henshin", "FeatureGen.henshin", "OrGroupGen.henshin", "AlternativeGen.henshin");
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(STATS_DIR + "executionTime.txt")));
		
		out.println("Features, FMs, Median Time (s), Mean Time (s), Std Time (s), Var Time");
		
		
		for (int nFeatures = 1; nFeatures <= MAX_FEATURES; nFeatures++) {
			System.out.println("Features: " + nFeatures + "...");
			List<FeatureModel> fms = getFMs(basedir, dynamicMetamodels, staticMetamodels, generators, nFeatures, nFeatures);
			Map<Integer, Long> times = executionTime_FMGeneration(basedir, dynamicMetamodels, staticMetamodels, generators, nFeatures, nFeatures);
			
			out.print(nFeatures + ",");
			out.print(fms.size() + ",");
			
			DescriptiveStatistics ds = new DescriptiveStatistics(times.values().stream().mapToDouble(d -> d*1e-9).toArray());
			out.print(ds.getPercentile(50) + ",");
			out.print(ds.getMean() + ",");
			out.print(ds.getStandardDeviation() + ",");
			out.print(ds.getVariance());
			
			out.println();
		}
		
		out.close();
		System.out.println("Done!");
	}
	
	private static Map<Integer, Long> executionTime_FMGeneration(String basedir, List<String> dynamicMetamodels, List<EPackage> staticMetamodels, List<String> generators, int nFeatures, int nConcreteFeatures) {
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
	
	private static List<FeatureModel> getFMs(String basedir, List<String> dynamicMetamodels, List<EPackage> staticMetamodels, List<String> generators, int nFeatures, int nConcreteFeatures) {
		LanguageExpressiveness le = new LanguageExpressiveness(basedir, dynamicMetamodels, staticMetamodels, generators, nFeatures, nConcreteFeatures);
		return le.getFeatureModels();
	}
}
