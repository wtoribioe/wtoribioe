/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labschapter1216aPrintWriter;

import java.io.File;
import java.util.Scanner;

//public class LabsChapter1216a {
 //   public static void main(String[] args) throws Exception {
        
       Scanner input = new Scanner(System.in);
     //  System.out.println("Enter the Source file: ");
     //  String str1 = input.nextLine();
     //  System.out.println("Enter the Target file: ");
     //  String str2 = input.nextLine();
       System.out.println("Enter the OldString file: ");
       String str3 = input.nextLine();
       System.out.println("Enter the NewString file: ");
       String str4 = input.nextLine();
       
        //Check command line parameter usage
      //  if (args.length != 4) {
      //      System.out.println("Usage: Java LabsChapter1216a sourceFile targetFile oldStr newStr");
      //      System.exit(1);
      //  }
       
        //Check if source file exists
        File sourceFile = new File("C:/Users/Wilfrido/Desktop/Java-2/LabsChapter1216a/src/labschapter1216a/score.txt");
        if(!sourceFile.exists()) {
            System.out.println("Source file " + sourceFile.getName() + " does not exist");
            System.exit(2);
        }
        //Check if target file exists
        File targetFile = new File("C:/Users/Wilfrido/Desktop/Java-2/LabsChapter1216a/src/labschapter1216a/score1.tx");
        if (targetFile.exists()) {
            System.out.println("Target file " + targetFile.getName() + " already exist");
            System.exit(3);
    }
        try (
            //Create input and out file
            Scanner inputfile =  new Scanner(sourceFile);
            java.io.PrintWriter output = new java.io.PrintWriter(targetFile);
                ) {
            while (inputfile.hasNext()) {
                    String str11 = inputfile.nextLine();
                    String str22 = str11.replaceAll(str3, str4);
                    output.println(str22);
                    System.out.println("OldString: " + str3);
                    System.out.println("NewString: " + str4);
                    System.out.println("ReplacedString: " + str22);
            }
        }
    }      
}
