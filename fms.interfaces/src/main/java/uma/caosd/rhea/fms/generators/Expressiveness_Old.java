package uma.caosd.rhea.fms.generators;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import uma.caosd.rhea.BasicFMmetamodel.FeatureModel;

public class Expressiveness_Old {
	public static final char[] ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	
	/**
	 * Generate the subset P \in F of concrete features.
	 * @param n	Number of concrete features.
	 * @return	P.
	 */
	public static List<String> getConcreteFeatures(int n) {
		List<String> p = new ArrayList<String>();
		
		for (int i = 0; i < n; i++) {
			int index = i/ALPHABET.length;
			String v = index == 0 ? "" : String.valueOf(index);
			p.add(ALPHABET[i%ALPHABET.length] + v);
		}
		return p;
	}

	public static EObject generateEmptyFeatureModel(EPackage metamodel) {
		EFactory mFactory = metamodel.getEFactoryInstance();
		EClass eclass = (EClass) metamodel.getEClassifier("FeatureModel");
		EObject fm = mFactory.create(eclass);
		
		return fm;
	}
	
	
//	public static EObject cloneFeatureModel(EObject fm, ) {
//		
//	}
	
	public static boolean containsAllFeatures(FeatureModel fm, List<String> features) {
		for (String name : features) {
			if (!fm.getFeatures().stream().anyMatch(f -> f.getName().equals(name))) {
				return false;
			}
		}
		return true;
	}
}
