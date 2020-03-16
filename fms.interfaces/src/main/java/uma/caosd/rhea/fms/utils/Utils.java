package uma.caosd.rhea.fms.utils;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
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
}
