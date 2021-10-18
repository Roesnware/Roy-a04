/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Trae Roy
 */

package baseline;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution43 {

    // static scanner
    private static final Scanner input = new Scanner(System.in);

    // input method
    private String inputMethod(String prompt) {
        System.out.println(prompt);
        return input.nextLine();
    }

    // main
    public static void main(String[] args) {

        Solution43 sol = new Solution43();

        // declare variables
        String path;
        String author, siteName;

        char js;
        char css;

        // prompt for website name
        siteName = sol.inputMethod("Site name: ");

        // prompt for author
        author = sol.inputMethod("Author: ");

        // prompt for javascript folder
        System.out.print("Do you want a folder for JavaScript? ");
        js = input.next().charAt(0);

        // prompt for css folder
        System.out.print("Do you want a folder for CSS? ");
        css = input.next().charAt(0);

        // get path
        path = System.getProperty("user.dir");

        // add site name to path
        path += "\\" + siteName;

        // make a new file object for path
        File website = new File(path);

        // make directory for new website
        boolean NewWebsite = website.mkdir();

        // if website created
        if(NewWebsite) {

            // make sub directories
            System.out.println("Created " + path);

            // try to create index.HTML website
            try {

                // create file write object
                FileWriter makeWebsite = new FileWriter(path + "\\index.html");

                // write data to website
                makeWebsite.write("<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n");
                makeWebsite.write("\t<meta author=\"" + author + "\">\n");
                makeWebsite.write("\t<title>" + siteName + "</title>\n");
                makeWebsite.write("</head>\n<body>\n\n</body>\n</html>");

                // close makeWebsite
                makeWebsite.close();

                // print html created
                System.out.println("Created " + path + "\\index.html");

                // if javaScriptCreated is yes then make javaScript folder
                if(js == 'y' || js == 'Y') {

                    // make javaScript file object
                    File javaScriptFolder = new File(path + "\\js");

                    // make sure javaScript folder is made correctly
                    boolean javaScriptCreated = javaScriptFolder.mkdir();

                    // print javaScript folder created
                    if(javaScriptCreated) {

                        System.out.println("Created " + javaScriptFolder + "\\");
                    } // else print javaScript folder not created
                    else {

                        System.out.println("Js folder not created!!");
                    }
                }

                // if css is yes then make css folder
                if(css == 'y' || css == 'Y') {

                    // make css file object
                    File cssFolder = new File(path + "\\css");

                    // make sure css folder is made correctly
                    boolean cssCreated = cssFolder.mkdir();

                    // print css folder created
                    if(cssCreated) {

                        System.out.println("Created " + cssFolder + "\\");
                    } // else print css folder not created
                    else {

                        System.out.println("CSS folder not created!!");
                    }
                }
            }

            // throw exception if file is empty
            catch(IOException e) {

                System.out.println("index.html not created as required!!");
            }
        } // print exception message because website not created
        else {

            System.out.println("\"Error: Website Not Created!!\"");
        }

        // close scanner
        input.close();
    }
}