package gburst;
import java.util.List;

public class Order {
	String name;
	List<Family> families;
	double aggregateSum;
	String parentName;
	
	
	public Order(String name, String parentName){
		this.name=name;
		aggregateSum = -1;
		this.parentName=parentName;
		
	}
	
	public void addFamily(Family fToAdd){
		if(families.contains(fToAdd)){
			return;
		}
		else if(fToAdd.parentName.equals(name)){
			families.add(fToAdd);
		}
	}
}
