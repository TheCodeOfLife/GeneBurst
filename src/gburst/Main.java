package gburst;

import java.io.File;
import java.util.ArrayList;

import com.google.gson.Gson;

public class Main {

	public static void main(String[] args){

		File inFile = new File("bin/test.csv");

		//Validate input file exists, permissions are correct
		try {    
			if (!inFile.exists() || !inFile.canRead()) { //SC_EVAL
				System.err.println("Error cannot locate or read input file: " +
						inFile.getName());
				System.exit(0);
			}
		} catch (Exception ex) {
			throw new RuntimeException(
					"This line of code should never be reached.", ex);
		}

		CSVArray Foo = new CSVArray(inFile);

		
		ArrayList<GeneBurst> bursts = new ArrayList<GeneBurst>();

		for(int site = 0; site<Foo.getLocation().length; site++){
			
			GeneBurst test = new GeneBurst("testBurst");
			for(int i=255;i<Foo.getLength();i++){ //loop through all Taxons
				if(Foo.getRow(i)[site]==0){
					continue;
				}
				test.getOrAddKingdom(new Kingdom(Foo.getLevel(i,  0)))
				.getOrAddPhylum(new Phylum(Foo.getLevel(i,  1)))
				.getOrAddClass(new Class(Foo.getLevel(i,  2)))
				.getOrAddOrder(new Order(Foo.getLevel(i, 3)))
				.getOrAddFamily(new Family(Foo.getLevel(i, 4)))
				.getOrAddGenus(new Genus(Foo.getLevel(i, 5), Foo.getRow(i)[site] ))
				;

			}
			
			bursts.add(test);
		}

		Gson gson = new Gson();
		String json = gson.toJson(bursts.get(0));
		System.out.print(json);


	}
}
