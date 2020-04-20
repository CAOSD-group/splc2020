package uma.caosd.rhea.fms.generators.tests;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Stats {
	private int runs;
	private int fms;
	private List<String> metamodels;
	private List<String> generators;
	private int nFeatures;
	private int nConcreteFeatures;
	private int abstractFeatures;
	
	private PrintWriter file;
	
	public Stats(String filepath) {
		try {
			file = new PrintWriter(new BufferedWriter(new FileWriter(filepath)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void generateHeader() {
		file.print("Runs,");
		file.print("Features,");
		file.print("Concrete Features,");
		file.print("Abstract Features,");
		file.print("FMs,");
		file.print("Metamodels,");
		file.print("Generators,");
		file.print("Median Time (ms),");
		file.print("Mean Time (ms),");
		file.print("Std Time (ms)");
		file.println();
	}
	
	public void addStats(int runs, int fms, List<String> metamodels, List<String> generators, int nFeatures, int nConcreteFeatures, int abstractFeatures, List<Long> times) {
		file.print(runs + ",");
		file.print(nFeatures + ",");
		file.print(nConcreteFeatures + ",");
		file.print(abstractFeatures + ",");
		file.print(fms + ",");
		for (String s : metamodels) {
			file.print(s + " ");
		}
		file.print(",");
		for (String s : generators) {
			file.print(s + " ");
		}
		file.print(",");
		
		DescriptiveStatistics ds = new DescriptiveStatistics();
		
	}


	public void addStat() {
		out.println();
	}
}

