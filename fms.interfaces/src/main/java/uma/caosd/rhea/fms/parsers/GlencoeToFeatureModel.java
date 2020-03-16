package uma.caosd.rhea.fms.parsers;

import java.util.List;
import java.util.Map;

import uma.caosd.rhea.BasicFMmetamodel.BasicFMmetamodelFactory;
import uma.caosd.rhea.BasicFMmetamodel.Feature;
import uma.caosd.rhea.BasicFMmetamodel.FeatureModel;
import uma.caosd.rhea.CardinalityBasedFMmetamodel.CardinalityBasedFMmetamodelFactory;
import uma.caosd.rhea.CardinalityBasedFMmetamodel.GroupFeature;
import uma.caosd.rhea.fms.utils.Utils;

public class GlencoeToFeatureModel implements FeatureModelParser {
	
	@Override
	public FeatureModel getFeatureModel(String filepath) {
		Map<?, ?> map = Utils.readJsonFile(filepath);
		
		FeatureModel fm = BasicFMmetamodelFactory.eINSTANCE.createFeatureModel();
		String name = (String) map.get("name");
		fm.setName(name);
	    
		Map<?,?> featuresInfo = (Map<?, ?>) map.get("features");
		Map<?,?> root = (Map<?, ?>) map.get("tree");
		addFeature(fm, root, null, featuresInfo);
		
		Map<?,?> constraints = (Map<?, ?>) map.get("constraints");
		for (Object constraint : constraints.values()) {
			addConstraint(fm, (Map<?, ?>) constraint, featuresInfo);
		}
		
		return fm;
	}
	
	
	private void addFeature(FeatureModel fm, Map<?, ?> feature, String parentId, Map<?, ?> featuresInfo) {
		String id = (String) feature.get("id");
		Map<?, ?> info = (Map<?, ?>) featuresInfo.get(id);
		String name = (String) info.get("name");
		boolean mandatory = ! (boolean) info.get("optional");
		String type = (String) info.get("type");
		List<?> children = (List<?>) feature.get("children");
		
		Feature f = null;
		if (type.equals("FEATURE")) {
			f = BasicFMmetamodelFactory.eINSTANCE.createFeature();
		} else if (type.equals("OR")) {
			f = CardinalityBasedFMmetamodelFactory.eINSTANCE.createGroupFeature();
			((GroupFeature) f).setLower(1);
			((GroupFeature) f).setUpper(children.size());
		} else if (type.equals("GENOR")) {
			f = CardinalityBasedFMmetamodelFactory.eINSTANCE.createGroupFeature();
			int lower = (int) info.get("min");
			int upper = (int) info.get("max");
			((GroupFeature) f).setLower(lower);
			((GroupFeature) f).setUpper(upper);
		} else if (type.equals("XOR")) {
			f = CardinalityBasedFMmetamodelFactory.eINSTANCE.createGroupFeature();
			((GroupFeature) f).setLower(1);
			((GroupFeature) f).setUpper(1);
		}
		f.setId(id);
		f.setName(name);
		f.setMandatory(mandatory);
		Feature parent = fm.getFeature(parentId);
		f.setParent(parent);
		if (parent == null) {
			fm.setRoot(f);
		} else {
			parent.getChildren().add(f);
		}
		fm.getFeatures().add(f);
		
		if (children != null) {
			for (Object child : children) {
				addFeature(fm, (Map<?, ?>) child, id, featuresInfo);
			}
		}
	}
	
	private void addConstraint(FeatureModel fm, Map<?, ?> constraint, Map<?, ?> featuresInfo) {
		String type = (String) constraint.get("type");
		List<?> operands = (List<?>) constraint.get("operands");
		
		// TODO Glencoe supports complex constraints (not only REQUIRES, EXCLUDES).
	}
}
