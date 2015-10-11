package gburst;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class GeneBurst {
	String name;
	
	@SerializedName("children")
	List<Kingdom> kingdoms;
	String description = name;

	
	
	public GeneBurst(String name){
		this.name=name;	
		kingdoms = new ArrayList<Kingdom>();
	}
	
	public Kingdom getOrAddKingdom(Kingdom kToAdd) {
		Kingdom result;
		int index = kingdoms.indexOf(kToAdd);
		if(index >= 0) result = kingdoms.get(index);
		else {
			result = kToAdd;
			kingdoms.add(result);
		}
		
		return result;
	}
}
