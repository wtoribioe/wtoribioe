/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labschapter1213PrintWriter;

import java.io.IOException;

public class LabsChapter1213PrintWriter {
    public static void main(String[] args) throws IOException { 
        
        java.io.File file = new java.io.File("score.txt");
        if (file.delete()) {
            System.out.println("File was deleted");
        }else if (!file.exists()) {
        //Create file
            java.io.PrintWriter output = new java.io.PrintWriter(file);       
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
        output.print("Johny Trace Square ");
        output.println(90);
        output.print("Erica Kong Janece ");
        output.println(95);
        output.print("Kimary Trevol Olive ");
        output.println(80);
        output.print("Hilda Marcel Native ");
        output.println(70);
        output.print("Jesus Toribio Ortiz ");
        output.println(50);
        output.print("Gabriela Toribio Smith ");
        output.println(40);
        output.print("Emmanuel Kirk Jones ");
        output.println(85);
        output.print("Katerine Garcia Ortiz ");
        output.println(60);
        output.print("Albania Toribio Ortiz ");
        output.println(70);
        output.print("Lizandro Toribio Ortiz ");
        output.println(80);
       
        //Close file
        System.out.println("Is it absolute? " + file.getAbsolutePath());
        System.out.println("The file has " + file.length() + " bytes");
        output.close();
    }
  }
}
