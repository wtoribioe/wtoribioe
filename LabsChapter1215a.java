/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labschapter1215a;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LabsChapter1215a {
    public static void main(String[] args) throws IOException, Exception {
        //Create a File instance
        String path = "C:/Users/Wilfrido/Desktop/Java-2/LabsChapter1217/Salary.txt";
        java.io.File file = new java.io.File(path);
        if (!file.exists()) {
            System.out.println("File: " + file.getName() + " does not exist");
            //Creating the file
            createFile(file);
            System.out.println("File " + file.getName() + " was created");
            System.out.println("Located at " + file.getAbsolutePath());
            System.out.println("The file size is " + file.length() + " bytes");
            System.out.println(" ");
            System.out.println("*** Reading the file ***\n ");
        } else if (file.exists()) {
            //Deleting the file first
            deleteFile(file);
            createFile(file);
            System.out.println("File " + file.getName() + " Created");
            System.out.println("Located at " + file.getAbsolutePath());
            System.out.println("The file size is " + file.length() + " bytes");
            System.out.println("Last modified on " + new java.util.Date(file.lastModified()));
            System.out.println(" ");
            System.out.println("*** Reading the file ***\n ");
        }
        //Read data from the file
        try ( 
            //Create Scanner for the file
            Scanner input = new Scanner(file)) {
            //Read data from the file
            while (input.hasNext()) {
                String firstName = input.next();
                String lastName = input.next();
                String rank = input.next();
                int salary = input.nextInt();
                System.out.println("First Name: " + firstName + ", " + "Last Name: "
                        + lastName + " " + rank + ", " + "Score: " + salary );
                System.out.println(" ");
            }
            //Close file
            System.out.println(" ");
            System.out.println("File " + file.getName() + " " + " Reading completed\n");
        }
    }
    private static void createFile(File file) throws Exception {
        //Write formated ouput to the file
        try ( 
            //Create file
                java.io.PrintWriter output = new java.io.PrintWriter(file)) {
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
        }
    }
    private static void deleteFile(File file) throws Exception {
        String path = "C:/Users/Wilfrido/Desktop/Java-2/LabsChapter1213/score.txt";
    	try {
        //    File file = new File(path);
            if(file.delete()){
    		System.out.println(file.getName() + " was deleted!");
            }else {
    		System.out.println("Delete operation was failed.");
            }
    	}catch(Exception e){
    	}
    }
}
    
