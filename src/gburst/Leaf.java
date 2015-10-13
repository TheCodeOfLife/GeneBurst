package gburst;

public class Leaf extends Container {
	
	double size;
	
	public Leaf(String name, double size){
		super(name);
		this.size=size;
	}
	
	public double getSize() {
		return this.size;
	}

}
