package uma.caosd.rhea.modularmetamodel.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import uma.caosd.rhea.BasicFMmetamodel.FeatureModel;
import uma.caosd.rhea.modularmetamodel.transformations.ToClafer;

/**
 * Clafer and Choco utilities.
 * 
 * @author Jose-Miguel Horcas
 *
 */
public class ClaferUtils {
	public static final String WORKING_DIR = "E:/Software/clafer-tools-0.4.5/";
	public static final String CLAFER_EXE = "clafer.exe";
	public static final String CHOCO_EXE = "chocosolver.jar";
	
	/**
	 * Given a feature model, it translates it to Clafer notation.
	 * 
	 * @param fm	Feature model.
	 * @return		Filepath of the Clafer model generated (.txt).
	 */
	public static String toClafer(String basedir, FeatureModel fm) {
		ToClafer toClafer = new ToClafer();
		String claferModel = toClafer.fm2text(fm);
		String modelPath = basedir + fm.getName() + ".txt";
		toClafer.serialize(claferModel, modelPath);
		
		return modelPath;
	}
	
	/**
	 * Compile the Clafer model to Choco mode.
	 * 
	 * @param claferModelFilepath	Filepath of the Clafer model (.txt)
	 * @return						Filepath of the compiled file (.js)
	 */
	public static String compileClafer(String claferModelFilepath) {
		Path p = Paths.get(claferModelFilepath);
		Utils.runCLI(new File(WORKING_DIR), new String[]{CLAFER_EXE, "-m", "choco", p.toAbsolutePath().toString()});
		String outputFile = p.toString().substring(0, p.toString().lastIndexOf('.')) + ".js";
		
		return outputFile;
	}
	
	/**
	 * Generate all configurations using ChocoSolver.
	 * 
	 * @param chocoModelFilepath	Filepath of the compiled file (.js)
	 * @return						Filepath of the configurations (.txt)
	 */
	public static String generateConfigurations(String chocoModelFilepath) {
		Path p = Paths.get(chocoModelFilepath);
		String outputFile = p.toString().substring(0, p.toString().lastIndexOf('.')) + "Configs.txt";
		Path outputPath = Paths.get(outputFile);
		Utils.runCLI(new File(WORKING_DIR), new String[]{"java", "-jar", CHOCO_EXE, "--file", p.toAbsolutePath().toString(), "--prettify", "--output", outputPath.toAbsolutePath().toString()});
		
		return outputFile;
	}
	
	/**
	 * Given a file with all configurations as Clafer (Choco) instances, it extracts all configurations.
	 * 
	 * @param filepath	Filepath to the configurations file.
	 * @return			List of configurations.
	 */
	public static List<List<String>> parserConfigs(String filepath) {
		List<List<String>> configs = new ArrayList<List<String>>();
		List<String> newConfig = null;
		
		FileInputStream inputStream = null;
		Scanner sc = null;

		try {
			inputStream = new FileInputStream(filepath);
			sc = new Scanner(inputStream, "UTF-8");
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				if (line.startsWith("===")) {		// Start a new configuration
					newConfig = new ArrayList<String>();
				} else if (line.startsWith("---")) { // End the current configuration
					configs.add(newConfig);
				} else {
					String feature = line.trim();
					if (!feature.equals("")) {
						newConfig.add(feature);
					}
				}
			}
			sc.close();
			inputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return configs;
	}
	
}
