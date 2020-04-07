package uma.caosd.rhea.fms.generators;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParserChocoConfigs {
	private List<List<String>> configs;
	
	public ParserChocoConfigs() {
		this.configs = new ArrayList<List<String>>();
	}
	
	public List<List<String>> parserConfigs(String filepath) {
		this.configs = new ArrayList<List<String>>();
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
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return configs;
	}
	
	public static void main(String[] args) {
		String filepath = "src/main/resources/BasicFMs/allFMs/Clafer/fm11Configs.txt";
		
		ParserChocoConfigs parser = new ParserChocoConfigs();
		List<List<String>> configs = parser.parserConfigs(filepath);
		
		for (List<String> config : configs) {
			System.out.println(config);
		}
		
		
	}
}
