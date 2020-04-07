package uma.caosd.rhea.fms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class PRuebas {

	public static void main(String[] args) {
		List<String> features = new ArrayList<String>();
		features.add("A");
		features.add("B");
		List<String> features2 = new ArrayList<String>();
		features2.add("A");
		features2.add("B");
		System.out.println(features.equals(features2));
		
		
		Set<FMConfig> set = new HashSet<FMConfig>();
		FMConfig c = new FMConfig(features);
		set.add(c);
		
		FMConfig c2 = new FMConfig(features2);
		set.add(c2);
		
		System.out.println(set);
		System.out.println(c.equals(c2));
		set.equals(set);
		
		
		Set<String> s1 = new HashSet<String>();
		s1.add("A");
		s1.add("A");
		System.out.println(s1);

	}

}
