package gburst;
import java.util.List;

public class Family {
	String name;
	List<Genus> genuses;
	double aggregateSum;
	String parentName;
	
	
	public Family(String name, String parentName){
		this.name=name;
		aggregateSum = -1;
		this.parentName=parentName;
		
	}
	
	public void addGenus(Genus gToAdd){
		if(genuses.contains(gToAdd)){
			System.out.println("This isn't supposed to happen");
		}
		else if(gToAdd.parentName.equals(name)){
			genuses.add(gToAdd);
		}
	}
}
