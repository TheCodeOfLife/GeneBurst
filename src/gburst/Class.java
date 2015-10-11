package gburst;
import java.util.List;

public class Class {

	String name;
	List<Order> orders;
	double aggregateSum;
	String parentName;
	
	
	public Class(String name, String parentName){
		this.name=name;
		aggregateSum = -1;
		this.parentName = parentName;
		
	}
	
	public void addOrder(Order oToAdd){
		if(orders.contains(oToAdd)){
			return;
		}
		else if(oToAdd.parentName.equals(name)){
			orders.add(oToAdd);
		}
	}
}
