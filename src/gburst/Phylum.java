package gburst;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Phylum {
	
	String name;
	String description;
	
	@SerializedName("children")
	List<Class> classes;

	
	
	public Phylum(String name){
		this.name = name;
		classes = new ArrayList<Class>();
		description = name;
	}
	
	
	public Class getOrAddClass(Class cToAdd) {
		Class result;
		int index = classes.indexOf(cToAdd);
		if(index >= 0) result = classes.get(index);
		else {
			result = cToAdd;
			classes.add(result);
		}
		
		return result;
	}
	
	@Override
	public boolean equals(Object o) {
		Phylum toCompare = (Phylum) o;
		return toCompare.name.equals(this.name);
	}
	
	@Override
	public int hashCode() {
		return this.name.hashCode();
	}
}
