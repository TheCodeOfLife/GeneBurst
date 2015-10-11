package gburst;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Order {
	String name;
	String description;


	@SerializedName("children")
	List<Family> families;

	
	
	public Order(String name){
		this.name=name;
		families = new ArrayList<Family>();	
		description = name;
	}
	
	
	
	public Family getOrAddFamily(Family fToAdd) {
		Family result;
		int index = families.indexOf(fToAdd);
		if(index >= 0) result = families.get(index);
		else {
			result = fToAdd;
			families.add(result);
		}
		
		return result;
	}
	
	@Override
	public boolean equals(Object o) {
		Order toCompare = (Order) o;
		return toCompare.name.equals(this.name);
	}
	
	@Override
	public int hashCode() {
		return this.name.hashCode();
	}
}
