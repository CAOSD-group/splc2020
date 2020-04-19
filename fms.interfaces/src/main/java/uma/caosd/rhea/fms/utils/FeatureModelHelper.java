package uma.caosd.rhea.fms.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import uma.caosd.rhea.BasicFMmetamodel.Feature;
import uma.caosd.rhea.BasicFMmetamodel.FeatureModel;

public class FeatureModelHelper {

	public static List<Feature> getFeatures(FeatureModel fm) {
		ArrayList<Feature> features = new ArrayList<Feature>();
		Feature root = fm.getRoot();
		
		if (root != null) {
			features.add(root);
			features.addAll(root.getChildren());
			
			Stack<Feature> stack = new Stack<Feature>();
			stack.addAll(root.getChildren());
			while (!stack.isEmpty()) {
				Feature f = stack.pop();
				features.addAll(f.getChildren());
				stack.addAll(f.getChildren());
			}
		}
		return features;		
	}
}
