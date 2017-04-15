/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labschapter1214aPrintWriter;

import java.io.IOException;

public class LabsChapter1214aPrintWriter {
    public static void main(String[] args) throws Exception {
        java.io.File file = new java.io.File("score1.txt");
        if (file.exists()) {
            System.out.println("File already exists");
            System.exit(1);
        }
        try (
        //Create file
        java.io.PrintWriter output = new java.io.PrintWriter(file);
        ) {
        //Write formated ouput to the file
        output.print("John Toribio Smith ");
        output.println(90);
        output.print("Eric King Jones ");
        output.println(95);
        output.print("Kimberlee Toribio Ortiz ");
        output.println(100);
        output.print("Pamela Toribio Ortiz ");
        output.println(100);
        output.print("Dorian Toribio Ortiz ");
        output.println(100);
        
        //Close file
        System.out.println("Is it absolute? " + file.getAbsolutePath());
        System.out.println("The file has " + file.length() + " bytes");
        //output.close();
    }
  }
}
