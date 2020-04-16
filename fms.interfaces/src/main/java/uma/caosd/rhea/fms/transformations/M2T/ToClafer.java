package uma.caosd.rhea.fms.transformations.M2T;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import uma.caosd.rhea.BasicFMmetamodel.Alternative;
import uma.caosd.rhea.BasicFMmetamodel.Feature;
import uma.caosd.rhea.BasicFMmetamodel.FeatureModel;
import uma.caosd.rhea.BasicFMmetamodel.OrGroup;

/**
 * Transform a feature model to a Clafer model.
 * 
 * @author Jose-Miguel Horcas
 *
 */
public class ToClafer {
	public static final String TAB = "\t";
	private String fmName;	
	
	public String fm2text(FeatureModel fm) {
		fmName = fm.getName();
		
		StringBuffer claferFM = new StringBuffer();
		
		traverseTree(claferFM, fm.getRoot(), 0);
		
		// Add the initial instance
		claferFM.append(fmName).append(": ").append(fm.getRoot().getName());
		
		return claferFM.toString();
	}
	
	public void traverseTree(StringBuffer claferFM, Feature feature, int tab) {
		addTabs(claferFM, tab);
		
		if (feature.isRoot()) {
			claferFM.append("abstract ").append(feature.getName());
		} else {
			if (feature instanceof Alternative) {
				claferFM.append("xor ");
			} else if (feature instanceof OrGroup) {
				claferFM.append("or " );
			}
			claferFM.append(feature.getName());
			if (!feature.isMandatory()) {	// Optional feature
				claferFM.append(" ?");
			}
		}
		claferFM.append(System.lineSeparator());	// End of line
		
		// Rest of children
		for (int i = 0; i < feature.getChildren().size(); i++) {
			traverseTree(claferFM, feature.getChildren().get(i), tab+1);
		}
		
	}
	
	private void addTabs(StringBuffer claferFM, int tab) {
		for (int j = 0 ; j < tab ; j++) {
			claferFM.append(TAB);
		}
	}
	
	public void serialize(String content, String outputFilepath) {
		try {
			Path path = Paths.get(outputFilepath);
			if (!Files.exists(path)) {
				Files.createDirectories(path.getParent());
				Files.createFile(path);
			}
			FileWriter writer = new FileWriter(path.toString());
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
