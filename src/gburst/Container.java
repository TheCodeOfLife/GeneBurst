package gburst;
import java.util.ArrayList;
import java.util.List;

public class Container {
	
	private String name;
	private List<Container> containers;	
	private double size;
	
	public Container(String name){
		this.name = name;
		containers = new ArrayList<Container>();
	}
	
	public Container(String name, double size){
		this.name=name;
		this.size=size;
	}
	
	public double getSize() {
		return this.size;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Container getOrAddContainer(Container cToAdd) {
		Container result;
		int index = containers.indexOf(cToAdd);
		if(index >= 0) result = containers.get(index);
		else {
			result = cToAdd;
			containers.add(result);
		}
		
		return result;
	}
	
	@Override
	public boolean equals(Object o) {
		Container toCompare = (Container) o;
		return toCompare.name.equals(this.name);
	}
	
	@Override
	public int hashCode() {
		return this.name.hashCode();
	}
}
