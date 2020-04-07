package uma.caosd.rhea.fms;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class FMConfig {
	private Set<String> features;
	
	public FMConfig(Collection<String> features) {
		this.features = new HashSet<String>(features);
	}
	
	public Set<String> getFeatures() {
		return this.features;
	}
	
	@Override
	public boolean equals(Object o) {
		return o instanceof FMConfig && ((FMConfig)o).features.equals(features);
	}
	
	@Override
	public int hashCode() {
		return features.hashCode();
	}
	
	@Override
	public String toString() {
		return this.features.toString();
	}
}
