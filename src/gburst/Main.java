package gburst;

import java.io.File;

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

		GeneBurst test = new GeneBurst("testBurst");


		for(int i=0;i<Foo.getLength();i++){ //loop through all Taxons
			Kingdom k = new Kingdom(Foo.getLevel(0,i));
			test.addKingdom(k);
		}
		for(int j=0;j<Foo.getLength();j++){ //loop through all Taxons
			for(int i=0;i<test.kingdoms.size();i++){ //loop through all Kingdoms
				test.kingdoms.get(i).addPhylum(Foo.getLevel(1,j), test.kingdoms.get(i).name); //run addPhylum on all Phylums (in 2nd array index)
			}	
		}
		for(int i=0;i<Foo.getLength();i++){//loop through all Taxons
			for(int j=0;j<test.kingdoms.size();j++){//loop through all Kingdoms
				for(int k=0;k<test.kingdoms.get(j).phylums.size(); k++){
					test.kingdoms.get(j).phylums.get(k).addClass(Foo.getLevel(2,i), test.kingdoms.get(j).phylums.get(k));
				}

			}
		}

		for(int i=0;i<Foo.getLength();i++){//loop through all Taxons
			for(int j=0;j<test.kingdoms.size();j++){//loop through all Kingdoms
				for(int k=0;k<test.kingdoms.get(j).phylums.size(); k++){
					for(int l=0;l<test.kingdoms.get(j).phylums.get(k).classes.size();l++){
						test.kingdoms.get(j).phylums.get(k).classes.get(l).addOrder(Foo.getLevel(3,i),test.kingdoms.get(j).phylums.get(k).classes.get(l));
					}
				}

			}
		}

		for(int i=0;i<Foo.getLength();i++){//loop through all Taxons
			for(int j=0;j<test.kingdoms.size();j++){//loop through all Kingdoms
				for(int k=0;k<test.kingdoms.get(j).phylums.size(); k++){
					for(int l=0;l<test.kingdoms.get(j).phylums.get(k).classes.size();l++){
						for(int m=0; m<test.kingdoms.get(j).phylums.get(k).classes.get(l).orders.size();m++){
							test.kingdoms.get(j).phylums.get(k).classes.get(l).orders.get(m).addFamily(Foo.getLevel(4,i),test.kingdoms.get(j).phylums.get(k).classes.get(l).orders.get(m));
						}
					}
				}

			}
		}

		for(int i=0;i<Foo.getLength();i++){//loop through all Taxons
			for(int j=0;j<test.kingdoms.size();j++){//loop through all Kingdoms
				for(int k=0;k<test.kingdoms.get(j).phylums.size(); k++){
					for(int l=0;l<test.kingdoms.get(j).phylums.get(k).classes.size();l++){
						for(int m=0; m<test.kingdoms.get(j).phylums.get(k).classes.get(l).orders.size();m++){
							for(int n=0; n<test.kingdoms.get(j).phylums.get(k).classes.get(l).orders.get(m).families.size();n++){
								test.kingdoms.get(j).phylums.get(k).classes.get(l).orders.get(m).families.get(n).addGenus(Foo.getLevel(5,i),test.kingdoms.get(j).phylums.get(k).classes.get(l).orders.get(m).families.get(n));
							}
						}
					}
				}

			}
		}




	}
}
