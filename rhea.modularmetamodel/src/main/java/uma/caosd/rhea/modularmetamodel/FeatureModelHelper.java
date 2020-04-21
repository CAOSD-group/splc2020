package uma.caosd.rhea.modularmetamodel;

import java.util.Iterator;
import java.util.List;

import uma.caosd.rhea.BasicFMmetamodel.Alternative;
import uma.caosd.rhea.BasicFMmetamodel.Feature;
import uma.caosd.rhea.BasicFMmetamodel.FeatureModel;
import uma.caosd.rhea.BasicFMmetamodel.OrGroup;

public class FeatureModelHelper {

	/**
	 * Check if the feature model is valid.
	 * 
	 * @param fm
	 * @param features
	 * @return
	 */
	public static boolean isValid(FeatureModel fm) {
		boolean valid = true;
		
		Iterator<Feature> it = fm.getFeatures().iterator();
		while (valid && it.hasNext()) {	
			Feature f = it.next();
			
			// Feature groups cannot be leafs
			valid = !(f.isLeaf() && (f instanceof Alternative || f instanceof OrGroup));
			
			// Feature groups must have at least 2 childs
			valid = valid &&  !(f.getChildren().size() < 2 && (f instanceof Alternative || f instanceof OrGroup));
			
			// Children of feature groups must be optional
			valid = valid && !((f instanceof Alternative || f instanceof OrGroup) && f.getChildren().stream().anyMatch(c -> c.isMandatory()));
		}
		return valid;
	}
	
	/**
	 * Check if all features are present in the feature model
	 * 
	 * @param fm
	 * @param features
	 * @return
	 */
	public static boolean isComplete(FeatureModel fm, List<String> features) {
		for (String name : features) {
			if (!fm.getFeatures().stream().anyMatch(f -> f.getName().equals(name))) {
				return false;
			}
		}
		return true;
	}
}
