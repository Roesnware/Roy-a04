/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 first_name last_name
 */

package baseline;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution45 {

    // static scanner
    private static final Scanner input = new Scanner(System.in);

    // input method
    private String inputMethod() {
        System.out.println("Enter the output file : ");
        return input.nextLine();
    }

    public static void main(String[] args) throws IOException {

        // make Solution45 class variable
        Solution45 sol = new Solution45();

        // prompt for output file
        String output = sol.inputMethod();

        // make readfile object
        ReadFile read = new ReadFile();

        // read file
        read.readFile();

        // get temp list from input
        ArrayList<String> list = read.getUtilize();

        // pass output file and list to write file for output
        WriteFile write = new WriteFile(output, list);

        // write output
        write.printToOutputFile();
    }
}


// class for ReadFile
class ReadFile{

    // declare variables
    private final ArrayList<String> temp;
    private final Scanner input;

    // constructor
    public ReadFile() throws FileNotFoundException {

        // declare list for input file
        temp = new ArrayList<>();

        // make file to input file
        File file = new File("./data/exercise45_input.txt");

        // make file scanner
        input = new Scanner(file);
    }

    public void readFile() {

        // error handling
        try {

            // scan input file and store in temp array
            while( input.hasNext() ) {

                String data = input.nextLine();
                temp.add(data);
            }
        } // when done close scanner object
        finally {
            input.close();
        }
    }

    //return the temp list
    public ArrayList<String> getUtilize() {

        return temp;
    }
}

// write to output class
class WriteFile{

    // declare variables
    private final FileWriter writer;
    private final ArrayList<String> list;

    // method for writing to output file
    public WriteFile(String name, ArrayList<String> list) throws IOException {

        // initialize variables
        writer = new FileWriter("./data/" + name);
        this.list = list;
    }

    // print to output file
    public void printToOutputFile() throws IOException {

        // loop through till end of input file
        for (String temp : list) {

            // replace utilize with use
            temp = temp.replaceAll("utilize", "use");

            // write to output file
            writer.write(temp + "\n");
        }

        // close the writer object
        writer.close();
    }
}