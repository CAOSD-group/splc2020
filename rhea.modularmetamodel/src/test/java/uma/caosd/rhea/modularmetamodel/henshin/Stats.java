package uma.caosd.rhea.modularmetamodel.henshin;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class Stats {	
	private PrintWriter file;

	public Stats(String filepath) {
		try {
			file = new PrintWriter(new BufferedWriter(new FileWriter(filepath)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		generateHeader();
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
		file.print("Variance Time,");
		file.print("Std Time (ms),");
		file.print("Configs,");
		file.print("Time Configs,");
		file.print("SPLs,");
		file.print("Time SPLs,");
		file.print("SPLs covered,");
		file.print("Time SPLs covered,");
		file.print("Expressiveness (%)");
		file.println();
	}

	public void addStats(int runs, 
			int fms, 
			List<String> metamodels, 
			List<String> generators, 
			int nFeatures, 
			int nConcreteFeatures, 
			int configurations,
			long timeConfiguration,
			int spls,
			long timeSpls,
			int splsCovered,
			long timeSplsCovered,
			Collection<Long> times) {

		file.print(runs + ",");
		file.print(nFeatures + ",");
		file.print(nConcreteFeatures + ",");
		file.print((nFeatures - nConcreteFeatures) + ",");
		file.print(fms + ",");
		for (String s : metamodels) {
			file.print(s + " ");
		}
		file.print(",");
		for (String s : generators) {
			file.print(s + " ");
		}
		file.print(",");

		DescriptiveStatistics ds = new DescriptiveStatistics(times.stream().mapToDouble(d -> d*1e-9).toArray());
		file.print(ds.getPercentile(50) + ",");
		file.print(ds.getMean() + ",");
		file.print(ds.getVariance() + ",");
		file.print(ds.getStandardDeviation() + ",");

		file.print(configurations + ",");
		file.print(timeConfiguration + ",");
		file.print(spls + ",");
		file.print(timeSpls + ",");
		file.print(splsCovered + ",");
		file.print(timeSplsCovered + ",");
		file.println((double)(splsCovered)/spls * 100);
	}
	public void addStats(int runs, 
			int fms, 
			List<String> metamodels, 
			List<String> generators, 
			int nFeatures, 
			int nConcreteFeatures, 
			int configurations,
			long timeConfiguration,
			int spls,
			long timeSpls,
			Collection<Long> times) {

		file.print(runs + ",");
		file.print(nFeatures + ",");
		file.print(nConcreteFeatures + ",");
		file.print((nFeatures - nConcreteFeatures) + ",");
		file.print(fms + ",");
		for (String s : metamodels) {
			file.print(s + " ");
		}
		file.print(",");
		for (String s : generators) {
			file.print(s + " ");
		}
		file.print(",");

		DescriptiveStatistics ds = new DescriptiveStatistics(times.stream().mapToDouble(d -> d*1e-9).toArray());
		file.print(ds.getPercentile(50) + ",");
		file.print(ds.getMean() + ",");
		file.print(ds.getVariance() + ",");
		file.print(ds.getStandardDeviation() + ",");

		file.print(configurations + ",");
		file.print(timeConfiguration + ",");
		file.print(spls + ",");
		file.print(timeSpls + ",");
		file.print("-,");
		file.print("-,");
		file.println("-");
	}


	public void close() {
		file.close();
	}
}


