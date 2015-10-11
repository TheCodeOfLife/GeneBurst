package gburst;
import java.util.List;

public class Kingdom {
	
	String name;
	List<Phylum> phylums;
	double aggregateSum;
	
	
	public Kingdom(String name){
		this.name=name;
		aggregateSum = -1;
		
	}
	
	public Phylum getOrAddPhylum(Phylum pToAdd) {
		Phylum result;
		int index = phylums.indexOf(pToAdd);
		if(index >= 0) result = phylums.get(index);
		else {
			result = new Phylum(pToAdd.name);
			phylums.add(result);
		}
		
		return result;
	}
	
}
