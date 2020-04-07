package uma.caosd.rhea.fms;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EPackage;

import com.google.common.collect.Sets;

import uma.caosd.rhea.BasicFMmetamodel.FeatureModel;
import uma.caosd.rhea.fms.generators.FeatureModelGenerator;

public class LanguageExpressiveness {
	public static final String FM_NAME = "fm";
	public static final char[] ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

	private FeatureModelGenerator fmGen;
	private List<FeatureModel> fms = null;						// L
	private Map<FeatureModel, FMProductLine> mapping = null;	// Mapping function M
	private Set<FMProductLine> productLines = null;				// S (distinct product lines)
	private Map<FeatureModel, Set<FMConfig>> configurations = null;	
	private List<String> features;
	private List<String> concreteFeatures;
	private List<String> abstractFeatures;
	
	public LanguageExpressiveness(EPackage metamodel, String generatorsFilepath, int nFeatures, int nConcreteFeatures) {
		this.fmGen = new FeatureModelGenerator(metamodel, generatorsFilepath);
		
		this.features = this.generateFeatures(nFeatures);
		this.concreteFeatures = this.features.subList(0, nConcreteFeatures);
		this.abstractFeatures = this.features.stream().filter(f -> !this.concreteFeatures.contains(f)).collect(Collectors.toList());
	}
	
	public List<String> getFeatures() {
		return features;
	}

	public List<String> getConcreteFeatures() {
		return concreteFeatures;
	}

	public List<String> getAbstractFeatures() {
		return abstractFeatures;
	}

	public List<String> getLanguageConstructs() {
		return null;
	}
	
	/**
	 * Generates all possible feature models for the given set of features.
	 * 
	 * @param features
	 * @return
	 */
	public List<FeatureModel> getFeatureModels() {
		if (fms == null) {
			this.fms = generateFeatureModels();
		}
		return this.fms;
	}

	public Map<FeatureModel, Set<FMConfig>> getConfigurations() {
		if (configurations == null) {
			this.configurations = generateConfigurations();
		}
		return this.configurations;
	}
	
	public Map<FeatureModel, FMProductLine> getMappingFunction() {
		if (mapping == null) {
			this.mapping = this.generateMapping();
		}
		return this.mapping;
	}
	
	public Set<FMProductLine> getProductLines() {
		if (productLines == null) {
			this.productLines = new HashSet<FMProductLine>(getMappingFunction().values());
		}
		return this.productLines;
	}
	
	private Map<FeatureModel, Set<FMConfig>> generateConfigurations() {
		Map<FeatureModel, Set<FMConfig>> configurations = new HashMap<FeatureModel, Set<FMConfig>>();
		for (FeatureModel fm : fms) {
			System.out.println("Generating configs for " + fm.getName() + "...");
			String claferModelFilepath = ClaferUtils.toClafer(fm);
			String chocoModelFilepath = ClaferUtils.compileClafer(claferModelFilepath);
			String configFile = ClaferUtils.generateConfigurations(chocoModelFilepath);
			List<List<String>> configs = ClaferUtils.parserConfigs(configFile);
			
			// Clean files
			try {
				Files.deleteIfExists(Paths.get(claferModelFilepath));
				Files.deleteIfExists(Paths.get(chocoModelFilepath));
				Files.deleteIfExists(Paths.get(configFile));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			// Clean configurations (remove abstract root of Clafer)
			String name = fm.getName();
			Set<FMConfig> fmConfigs = new HashSet<FMConfig>();
			for (List<String> c : configs) {
				c.remove(name);
				fmConfigs.add(new FMConfig(c));
			}	
			configurations.put(fm, fmConfigs);
		}
		return configurations;
	}
	
	private Map<FeatureModel, FMProductLine> generateMapping() {
		Map<FeatureModel, FMProductLine> mapping = new HashMap<FeatureModel, FMProductLine>();
		for (FeatureModel fm : getFeatureModels()) {
			Set<FMConfig> configs = getConfigurations().get(fm);
			Set<FMConfig> pl = new HashSet<FMConfig>();
			for (FMConfig c : configs) {
				// Remove abstract features
				Set<String> validProgram = c.getFeatures().stream().filter(f -> concreteFeatures.contains(f)).collect(Collectors.toSet());
				pl.add(new FMConfig(validProgram));
			}
			mapping.put(fm, new FMProductLine(pl));
		}
		return mapping;
	}
	
	private List<FeatureModel> generateFeatureModels() {
		FeatureModel fm = fmGen.generateEmptyFeatureModel(FM_NAME);
		List<FeatureModel> fms = fmGen.generateFeatureModels(fm, features);
		for (int i = 0; i < fms.size(); i++) {
			fms.get(i).setName(FM_NAME + (i+1));
		}
		return fms;
	}
	
	/**
	 * Generate the set F of features.
	 * @param n	Number of features.
	 * @return	List of features.
	 */
	private List<String> generateFeatures(int n) {
		List<String> p = new ArrayList<String>();
		
		for (int i = 0; i < n; i++) {
			int index = i/ALPHABET.length;
			String v = index == 0 ? "" : String.valueOf(index);
			p.add(ALPHABET[i%ALPHABET.length] + v);
		}
		return p;
	}
	
	public static Set<FMConfig> getAllPossibleConfigurations(List<String> features) {
		Set<Set<String>> powerSet = Sets.powerSet(new HashSet<String>(features));		// Guava dependency
		
		Set<FMConfig> configurations = new HashSet<FMConfig>();
		for (Set<String> s : powerSet) {
			configurations.add(new FMConfig(s));
		}
		return configurations;
	}
	
	public static Set<FMProductLine> getAllPossibleProductLines(List<String> features) {
		Set<FMConfig> configs = getAllPossibleConfigurations(features);
		Set<Set<FMConfig>> ppSet = Sets.powerSet(configs);							// Guava dependency
		
		Set<FMProductLine> pls = new HashSet<FMProductLine>();
		for (Set<FMConfig> s : ppSet) {
			pls.add(new FMProductLine(s));
		}
		return pls;
	}
}
