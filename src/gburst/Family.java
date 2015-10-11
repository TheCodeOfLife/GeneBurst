package gburst;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Family {
	String name;
	String description;

	
	@SerializedName("children")
	List<Genus> genuses;

	
	
	public Family(String name){
		this.name=name;
		genuses = new ArrayList<Genus>();	
		description = name;
	}
	
	
	public Genus getOrAddGenus(Genus gToAdd) {
		Genus result;
		int index = genuses.indexOf(gToAdd);
		if(index >= 0) result = genuses.get(index);
		else {
			result = gToAdd;
			genuses.add(result);
		}
		
		return result;
	}
	
	@Override
	public boolean equals(Object o) {
		Family toCompare = (Family) o;
		return toCompare.name.equals(this.name);
	}
	
	@Override
	public int hashCode() {
		return this.name.hashCode();
	}
}
