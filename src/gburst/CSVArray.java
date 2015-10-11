package gburst;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CSVArray {

	private final double[][] gData;
	private final String[] locations;
	private final String[][] taxonomy;

	public CSVArray(File inFile) {
		ArrayList<String[]> fileArray = new ArrayList<String[]>();
		try {
			Scanner in = new Scanner(inFile);
			while (in.hasNextLine()) {
				String temp = in.nextLine();
				fileArray.add(temp.split(","));
			}
			in.close();
		} catch (FileNotFoundException ex) {
			throw new IllegalArgumentException("Invalid file");
		}

		//Create location array
		String[] locTemp = new String[fileArray.get(0).length - 1];
		for (int i = 1; i < fileArray.get(0).length; i++) {
			locTemp[i - 1] = fileArray.get(0)[i];
		}
		locations = locTemp.clone();

		//Create taxonomy array
		taxonomy = new String[fileArray.size() - 1][];
		for (int i = 1; i < fileArray.size(); i++) {
			taxonomy[i - 1] = fileArray.get(i)[0].split(";");
		}

		//Create data array
		gData = new double[fileArray.size() - 1][fileArray.get(0).length - 1];
		for (int i = 1; i < fileArray.size(); i++) {
			for (int j = 1; j < fileArray.get(i).length; j++) {
				gData[i - 1][j - 1] = Double.parseDouble(fileArray.get(i)[j]);
			}
		}

		System.out.println(Arrays.deepToString(taxonomy));
		//System.out.println(Arrays.deepToString(gData));
		//System.out.println(Arrays.toString(locations));
	}
	
	public int getLength() {
		return this.gData.length;
	}

	public int getWidth() {
		return this.locations.length;
	}
	
	public String getLevel(int row, int level) { 
		return taxonomy[row][level];
	}
	
	public double[] getRow(int row) {
		return this.gData[row].clone();
	}
	
	public double[] getColumn(int column) {
		double[] res = new double[this.gData.length];
		for (int i = 0; i < this.gData.length; i++) {
			res[i] = this.gData[i][column];
		}
		return res;
	}
	
	public double getIndex(int x, int y) {
		return this.gData[x][y];
	}

}