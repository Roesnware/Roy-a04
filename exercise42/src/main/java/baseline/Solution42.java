/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Trae Roy
 */


package baseline;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution42 {

    // main
    public static void main(String[] args) {

        // class variable sol
        Solution42 sol = new Solution42();

        // print header
        System.out.printf("%-17s%-17s%-17s\n", "Last", "First", "Salary");

        // print line spacer
        System.out.println("----------------------------------------");

        // print using printOutput
        sol.printOutput("./data/exercise42_input.txt");
    }

    // output method
    public void printOutput(String filename) {
        // try to read input file
        try {
            File file = new File(filename);
            Scanner in = new Scanner(file);

            // continue while there's a name on next line, parse using regex
            while (in.hasNext()) {
                String scan = in.nextLine();
                String[] temp = scan.split(",");
                System.out.printf("%-17s%-17s%-17s\n", temp[0], temp[1], temp[2]);
            }

            // else no file print exception
        } catch (FileNotFoundException ex) {
            System.out.println("Error: File Not Found!!");
        }
    }
}