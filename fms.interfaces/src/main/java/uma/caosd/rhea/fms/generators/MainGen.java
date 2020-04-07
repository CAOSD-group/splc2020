package uma.caosd.rhea.fms.generators;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;

import uma.caosd.rhea.BasicFMmetamodel.BasicFMmetamodelPackage;
import uma.caosd.rhea.BasicFMmetamodel.FeatureModel;
import uma.caosd.rhea.fms.transformations.M2T.ToClafer;
import uma.caosd.rhea.fms.utils.EMFIO;

public class MainGen { 

	/**
	 * Generate all feature models for the number of concrete feature given N.
	 * 
	 */
	public static void main(String[] args) throws IOException {
		// Variables
		int N = 2;												
		String basedir = "src/main/resources/BasicFMs/";
		String allFMsDir = basedir + "allFMs/";
		String claferModelsDir = basedir + "allFMs/Clafer/";
		String fmName = "fm1";
		EPackage metamodel = BasicFMmetamodelPackage.eINSTANCE;
		String generatorsFilepath = basedir + "BasicFMgenerators.henshin"; 
		String claferExeDir = "E:/Software/clafer-tools-0.4.5/";
		String claferExe = "clafer.exe";
		String chocoExe = "chocosolver.jar";
		
		// Start the pipeline
		// Clean directories
		cleanUp(allFMsDir);
		
		FeatureModelGenerator fmGen = new FeatureModelGenerator(metamodel, generatorsFilepath);

		// Generate emtpy fm
		FeatureModel fm = fmGen.generateEmptyFeatureModel(fmName);
		String fmFilepath = basedir + fmName + ".xmi";
		EMFIO.saveModel(fm, metamodel, fmFilepath);
		
		List<String> features = Expressiveness_Old.getConcreteFeatures(N);
		//features.add(0, "Root");
		
		// Generate feature models
		List<FeatureModel> fms = fmGen.generateFeatureModels(fm, features);
		
		// Enumerate feature models (change the name of each feature model)
		for (int i = 0; i < fms.size(); i++) {
			fms.get(i).setName("fm" + (i+1));
		}
		
		// Serialize the models
		for (int i = 0; i < fms.size(); i++) {
			//System.out.println(fms.get(i).getName());
			EMFIO.saveModel(fms.get(i), metamodel, allFMsDir + fms.get(i).getName() + ".xmi");
		}
		System.out.println("Size: " + fms.size());
		

		System.out.println("********** Transform FMs to Clafer models **********");
		//cleanUp(claferModelsDir);
		
		// Transform to clafer models
		for (int i = 0; i < fms.size(); i++) {
			ToClafer toClafer = new ToClafer();
			String s = toClafer.fm2text(fms.get(i));
			String modelPath = claferModelsDir + fms.get(i).getName() + ".txt";
			toClafer.serialize(s, modelPath); 
		}
		
		
		System.out.println("********** Compile Clafer models **********");
		// Compile Clafer models for Choco
		Path claferPath = Paths.get(claferExe).toAbsolutePath();
		Files.list(Paths.get(claferModelsDir)).forEach(p -> 
					{
						System.out.println(claferPath);
						System.out.println(p.toString());
						runCLI(new File(claferExeDir), new String[]{claferExe, "-m", "choco", p.toAbsolutePath().toString()});
					}
				);
		
		System.out.println("********** Generate configurations with Choco **********");
		// Generate configurations with Choco
		Path chocoPath = Paths.get(chocoExe).toAbsolutePath();
		Files.list(Paths.get(claferModelsDir)).filter(p -> p.toString().endsWith(".js")).forEach(p -> 
					{
						System.out.println(chocoPath);
						System.out.println(p.toAbsolutePath().toString());
						String outputFile = p.toString().substring(0, p.toString().lastIndexOf('.')) + "Configs.txt";
						Path outputPath = Paths.get(outputFile);
						System.out.println(outputPath.toAbsolutePath().toString());
						runCLI(new File(claferExeDir), new String[]{"java", "-jar", chocoExe, "--file", p.toAbsolutePath().toString(), "--prettify", "--output", outputPath.toAbsolutePath().toString()});
					}
				);
		
		System.out.println("********** Parser Choco configurations **********");
		
		ParserChocoConfigs parser = new ParserChocoConfigs();
		Files.list(Paths.get(claferModelsDir)).filter(p -> p.toString().endsWith("Configs.txt")).forEach(p -> 
		{
			List<List<String>> configs = parser.parserConfigs(p.toAbsolutePath().toString());
			System.out.println(configs);
		}
	);
		
	}
	
	/**
	 * Execute the command line process.
	 *  
	 * @param directory		Working directory
	 * @param arguments		Program to be execute with arguments.
	 */
	public static void runCLI(File directory, String... arguments) {
		ProcessBuilder processBuilder = new ProcessBuilder();
		processBuilder.command(arguments);
		processBuilder.directory(directory);
		
		try {			
			Process process = processBuilder.start();

			int exitVal = process.waitFor();
			if (exitVal != 0) {
				System.out.print("Error! running ");
				for (String arg : arguments) {
					System.out.print(arg + " ");	
				}
				System.out.println();
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	 /**
     * Clean up the rule serialisation directory.
     * 
     * @param baseDir	Base dir.
     * @param folder	Folder name to be cleaned.
     */
	public static void cleanUp(String folder) {
		try {
			Path resourceSetRoot = Paths.get(folder);
			File file = resourceSetRoot.toFile();
		
			if(file.exists()) {
				//LOGGER.log(Level.INFO, String.format("Found existing directory %s. Deleting it.", file.getAbsolutePath()));
				
				Files.walk(file.toPath())
				    .sorted(Comparator.reverseOrder())
				    .map(Path::toFile)
				    .forEach(File::delete);
			}
		} catch (IOException e) {
			//LOGGER.log(Level.SEVERE, "Error cleaning up directory for generated rules.");
			e.printStackTrace();
		}
	}
	
}
