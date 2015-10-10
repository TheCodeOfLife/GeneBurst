package gburst;

import java.io.File;

public class GDataProcessor {
	
    public static final int ARGS_AMNT = 1;

	/**
	 * Sanity check for user input
	 * @param args user input
	 * @return true only if formatted as requested
	 */
	public static boolean validateArgs(String[] args) {
		//Verify there is only one string, a file
		if ((null == args) || (args.length != ARGS_AMNT)) { //SC_EVAL
			throw new IllegalArgumentException("Invalid number of arguments");
		} else if (null == args[0] || args[0].length() == 0) { //SC_EVAL
			throw new IllegalArgumentException("Invalid input");
		}
		return true;
	}
	
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
