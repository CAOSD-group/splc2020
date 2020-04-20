package uma.caosd.rhea.modularmetamodel.utils;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class Utils {

	public static List<String> readFile(String filepath) {
		Path path = Paths.get(filepath);
		try {
			return Files.readAllLines(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ArrayList<String>();
	}
	
	public static Map<?,?> readJsonFile(String filepath) {
		Map<?,?> map = new HashMap<Object,Object>();
		
		try {
			// create Gson instance
		    Gson gson = new Gson();

		    // create a reader
		    Reader reader = Files.newBufferedReader(Paths.get(filepath));

		    // convert JSON file to map
		    map = gson.fromJson(reader, Map.class);

		    // close reader
		    reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return map;
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
     * Clean up the serialisation directory.
     * 
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
