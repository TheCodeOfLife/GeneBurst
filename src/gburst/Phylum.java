package gburst;
import java.util.List;

public class Phylum {
	
	String name;
	String parentName;
	List<Class> classes;
	double aggregateSum;
	
	
	public Phylum(String name){
		this.name = name;
		aggregateSum = -1;
	}
	
	public void addClass(Class cToAdd){
		if(classes.contains(cToAdd)){
			return;
		}
		else if(cToAdd.parentName.equals(name)){
			classes.add(cToAdd);
		}
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
