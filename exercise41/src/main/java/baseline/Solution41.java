package baseline;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution41 {

    // main
    public static void main(String[] args)throws FileNotFoundException {

        // create Solution41 class variable
        Solution41 sol2 = new Solution41();

        // create a scanner to read from input file
        Scanner inputFileReader = new Scanner(new File("./data/exercise41_input.txt"));

        // declare an ArrayList for Strings to store the input names from the file
        ArrayList<String> names = new ArrayList<>();

        // read the names from the input file with readNamesFromInput
        readNamesFromInput(inputFileReader, names);

        // sort the list of names in alphabetical order using sort function
        names.sort(String.CASE_INSENSITIVE_ORDER);

        // close the scanner after reading the entire input file
        inputFileReader.close();

        // write the data to the output file
        try {
            sol2.outputNames(names);
        }
        // print any exception that may happen when writing to output file
        catch (Exception e) {
            System.out.println(e);
        }
    }

    // for writing sorted names to output
    public void outputNames(ArrayList<String> names) throws IOException {

        // create a file writer for output file
        FileWriter output = new FileWriter("./data/exercise41_output.txt");

        // write the number of names to the output file and put a line spacer
        output.write("Total of "+names.size()+" names\n");
        output.write("--------------------\n");

        // write the names in the file
        for (String i : names) {
            output.write(i + "\n");
        }

        // close output file
        output.close();
    }

    // define function to scan the data from Scanner to the ArrayList
    public static void readNamesFromInput(Scanner in, ArrayList<String> names) {

        // read the data till the file is empty
        while (in.hasNextLine()) {

            // add the name to the list of names
            names.add(in.nextLine());
        }
    }
}