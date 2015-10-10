package gburst;

import java.io.File;

public class GDataProcessor {
	
    /**
     * @param args <file1>
     */
    public static void main(String[] args) {

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
        
        CSVArray test = new CSVArray(inFile);

    }

}
