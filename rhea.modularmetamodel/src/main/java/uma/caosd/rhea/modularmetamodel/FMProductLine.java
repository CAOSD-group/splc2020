package uma.caosd.rhea.modularmetamodel;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class FMProductLine {
	private Set<FMConfig> configs;
		
	public FMProductLine(Collection<FMConfig> configs) {
		this.configs = new HashSet<FMConfig>(configs);
	}
	
	public Set<FMConfig> getConfigurations() {
		return this.configs;
	}
	
	@Override
	public boolean equals(Object o) {
		return o instanceof FMProductLine && ((FMProductLine)o).configs.equals(configs);
	}
	
	@Override
	public int hashCode() {
		return configs.hashCode();
	}
	
	@Override
	public String toString() {
		return this.configs.toString();
	}
}
