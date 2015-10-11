package gburst;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Class {

	String name;
	String description;

	
	@SerializedName("children")
	List<Order> orders;	

	
	public Class(String name){
		this.name=name;
		orders = new ArrayList<Order>();
		description = name;
		
	}
	
	
	public Order getOrAddOrder(Order oToAdd) {
		Order result;
		int index = orders.indexOf(oToAdd);
		if(index >= 0) result = orders.get(index);
		else {
			result = oToAdd;
			orders.add(result);
		}
		
		return result;
	}
	
	@Override
	public boolean equals(Object o) {
		Class toCompare = (Class) o;
		return toCompare.name.equals(this.name);
	}
	
	@Override
	public int hashCode() {
		return this.name.hashCode();
	}
}
