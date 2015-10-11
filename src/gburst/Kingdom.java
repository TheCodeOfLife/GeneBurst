package gburst;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Kingdom {
	
	String name;
	String description;
	@SerializedName("children")
	List<Phylum> phylums;
	

	
	
	
	public Kingdom(String name){
		this.name=name;	
		phylums = new ArrayList<Phylum>();
		description = name;
	}
	
	public Phylum getOrAddPhylum(Phylum pToAdd) {
		Phylum result;
		int index = phylums.indexOf(pToAdd);
		if(index >= 0) result = phylums.get(index);
		else {
			result = pToAdd;
			phylums.add(result);
		}
		
		return result;
	}
	
	public boolean equals(Object o) {
		Kingdom toCompare = (Kingdom) o;
		return toCompare.name.equals(this.name);
	}
	
	@Override
	public int hashCode() {
		return this.name.hashCode();
	}
	
}
