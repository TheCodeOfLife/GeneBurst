package gburst;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
	
	private static Container generateTree(Container cont, CSVArray input, int row, int treeLevel, int site) {
		if (treeLevel == input.getNumLevels() - 1) {
			return cont.getOrAddContainer(new Container(input.getLevel(row, treeLevel), input.getIndex(row, site)));
		} else {
			cont.getOrAddContainer(generateTree(new Container(input.getLevel(row, treeLevel+1)), input, row, treeLevel+1, site));
		}
		return cont;
	}

	public static void main(String[] args){

		File inFile = new File("test.csv");

		//Validate input file exists, permissions are correct
		try {    
			if (!inFile.exists() || !inFile.canRead()) { //SC_EVAL
				throw new FileNotFoundException("Cannot locate or read input file: " +
						inFile.getName());
			}
		} catch (Exception ex) {
			throw new RuntimeException("Cannot locate or read input file: " +
					inFile.getName(), ex);
		}

		CSVArray input = new CSVArray(inFile);

		ArrayList<Container> bursts = new ArrayList<Container>();

		for(int site = 0; site<input.getWidth(); site++) {
			Container cont = new Container("mainTree");
			for(int row=0;row<input.getLength();row++){ //loop through all Taxons
				if(input.getIndex(row, site)==0){
					continue;
				}
				int treeLevel = 1;
				cont.getOrAddContainer(generateTree(new Container(input.getLevel(row, treeLevel)), input, row, treeLevel, site));
			}

		/*
		for(int site = 0; site<input.getLocations().length; site++) {
			Container cont = new Container("testBurst");
			for(int i=255;i<input.getLength();i++){ //loop through all Taxons
				if(input.getRow(i)[site]==0){
					continue;
				}
				cont.getOrAddContainer(new Container(input.getLevel(i,  0)))
				.getOrAddContainer(new Container(input.getLevel(i,  1)))
				.getOrAddContainer(new Container(input.getLevel(i,  2)))
				.getOrAddContainer(new Container(input.getLevel(i, 3)))
				.getOrAddContainer(new Container(input.getLevel(i, 4)))
				.getOrAddContainer(new Container(input.getLevel(i, 5), input.getIndex(i, site)))
				;

			}
			*/
			bursts.add(cont);
		}

		try {
			PrintWriter out = new PrintWriter("output.json");
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			out.println("{\"" + input.getSite(0) + "\":");
			for (int i = 0; i < bursts.size() - 5; i++) {
				String json = gson.toJson(bursts.get(i));
				out.println(json.toString());
				if (i < input.getWidth()) {
					out.print(",");
					out.println("\"" + input.getSite(i + 1) + "\":");
				}
			}
			out.println("};");
			out.close();
		} catch (FileNotFoundException ex) {
			System.err.println("This line of code should never be reached");
		}
		System.out.println("JSON generation successful");
	}
}
