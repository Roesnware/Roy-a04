/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Trae Roy
 */

package baseline;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Solution46 {
    public static void main(String[] args) throws FileNotFoundException {

// create an object of ReadInputFile file
        ReadInputFile read = new ReadInputFile();

        //read file
        read.readFile();

        // get map
        HashMap<String, Integer> map = read.getMap();

        // create an object of PrintReport class and
        PrintOutput output = new PrintOutput(map);

        // print it on screen
        output.printScreen();
    }
}

// class to read file
class ReadInputFile{

    // declare variables
    private final Scanner input;
    private final HashMap<String, Integer> map;

    // method to read input file
    public ReadInputFile() throws FileNotFoundException {

        // file for input file
        File file = new File("./data/exercise46_input.txt");
        input = new Scanner(file);
        map = new HashMap<>();
    }

    // read file
    public void readFile() {

        // error handling
        try {

            // loop while not null
            while( input.hasNext() ) {

                // read input whole line
                String inputFile = input.nextLine();

                // split it by spaces
                String[] arr = inputFile.split(" ");

                // for loop to loop thorugh input file
                for (String key : arr) {

                    // if key is already in map then
                    if (map.containsKey(key)) {

                        // update value
                        int value = map.get(key);
                        value++;
                        map.put(key, value);

                    }// else put it in the map
                    else {

                        map.put(key, 1);
                    }
                }
            }
        } // at end close scanner object
        finally {
            input.close();
        }
    }

    // method for getting map
    public HashMap<String, Integer> getMap(){

        return map;
    }
}

// class to print output
class PrintOutput{

    // constant map
    private final HashMap<String, Integer> map;

    // print output method
    public PrintOutput( HashMap<String, Integer> map) {

        // initialize constructor
        this.map = map;
    }

    // method for print histogram on screen
    public void printScreen() {

        // declare key and value array
        String[] keys = new String[map.size()];
        Integer[] values = new Integer[map.size()];

        // initialize k index variable
        int k = 0;

        // iterate map
        for (Map.Entry<String, Integer> entry : map.entrySet()) {

            // store key and value in respective arrays
            keys[k] = entry.getKey();
            values[k++] = entry.getValue();
        }

        // declare another arrays of String and Integer to Store values
        int[] tempVal = new int[map.size()];
        String[] tempKey = new String[map.size()];

        // copy temp values array to values
        for(int i = 0; i < values.length; i++) {

            tempVal[i] = values[i];
        }


        // reverse sort values
        Arrays.sort(values, Collections.reverseOrder());

        // sort keys according to values array
        for(int i = 0; i < map.size(); i++) {

            // initialize value array at index
            int value = values[i];

            for(int j = 0; j < tempVal.length; j++) {

                if(value == tempVal[j]) {

                    // store keys in temp keys array
                    tempKey[i] = keys[j];
                    break;
                }
            }
        }
        // print new line
        System.out.println();

        // print histogram
        for(int i = 0; i < map.size(); i++) {

            int value = map.get(tempKey[i]);
            System.out.print(tempKey[i] + " : \t");

            for(int j = 0; j < value; j++) {

                // print '*'
                System.out.print("*");
            }
            // print new line
            System.out.println();
        }
    }
}