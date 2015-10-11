package gburst;
import java.util.List;

public class GeneBurst {
	String name;
	List<Kingdom> kingdoms;
	
	
	public GeneBurst(String name){
		this.name=name;		
	}
	
	public void addKingdom(Kingdom kToAdd){
		if(kingdoms.contains(kToAdd)){
			return;
		}
		else{
			kingdoms.add(kToAdd);
			kingdoms.get(kingdoms.size()-1);
		}
	}
}
