package fms.interfaces;

import uma.caosd.rhea.BasicFMmetamodel.Feature;
import uma.caosd.rhea.BasicFMmetamodel.FeatureModel;
import uma.caosd.rhea.fms.parsers.GlencoeToFeatureModel;

public class GlencoeToFeatureModelTest {

	public static void main(String[] args) {
		String filepath = "src/main/resources/BeverageVendingMachines.gfm.json";
		
		GlencoeToFeatureModel p = new GlencoeToFeatureModel();
		FeatureModel fm = p.getFeatureModel(filepath);
		for (Feature f : fm.getFeatures()) {
			System.out.println(f);
		}
		
		System.out.println(fm.getRoot());
		System.out.println(fm.getRoot().getChildren().size());
	}
}
