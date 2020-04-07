package uma.caosd.rhea.fms;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;

import uma.caosd.rhea.BasicFMmetamodel.BasicFMmetamodelPackage;
import uma.caosd.rhea.BasicFMmetamodel.FeatureModel;
import uma.caosd.rhea.fms.utils.EMFIO;
import uma.caosd.rhea.fms.utils.Utils;

public class Main {
	public static final String BASE_DIR = "BasicFMs/tmp/";
	
	public static final String basedir = "src/main/resources/BasicFMs/";
	public static final String allFMsDir = basedir + "allFMs/";
	public static final EPackage metamodel = BasicFMmetamodelPackage.eINSTANCE;
	public static final String metamodelFilepath = basedir + "BasicFMmetamodel.ecore";
	public static final String generatorsFilepath = basedir + "BasicFMgenerators.henshin"; 
	public static final String fmName = "fm";
	public static final int N_FEATURES = 3;
	public static final int CONCRETE_FEATURES = 2;
	
	public static void main(String[] args) throws IOException {
		Utils.cleanUp(BASE_DIR);
		
		//EPackage metamodel = (EPackage) EMFIO.loadMetamodel(metamodelFilepath);
		//System.out.println(metamodel);
		
		LanguageExpressiveness le = new LanguageExpressiveness(metamodel, generatorsFilepath, N_FEATURES, CONCRETE_FEATURES);
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(basedir + "stats.txt")));
		
        out.println("********** METAMODELS AND LANGUAGE CONSTRUCTS **********");
        out.println("Metamodels: " + metamodel.getName() + " (ToDo: Generalize for n metamodels)");
        out.println("Language constructs: ToDo");
        
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
		out.println("#FMs: " + fms.size());
//		for (FeatureModel fm : fms) {
//			out.println("FM: " + fm);
//		}
		
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
		
		
		Utils.cleanUp(BASE_DIR);
		
		out.close();
	}
}

