/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *///"C:/Users/Wilfrido/Desktop/Java-2/LabsChapter1216a/src/labschapter1216a/score.txt"
    //"C:/Users/Wilfrido/Desktop/Java-2/LabsChapter1216a/src/labschapter1216a/score1.tx"
package labschapter1216aPrintWriter;

import java.io.File;
import java.util.Scanner;

public class LabsChapter1216b {
    public static void main(String[] args) throws Exception {
       
        //Check command line parameter usage
        if (args.length != 4) {
           System.out.println("Usage: Java LabsChapter1216a sourceFile targetFile oldStr newStr");
            System.exit(1);
        }
        //Check if source file exists
        File sourceFile = new File(args[0]);
        if(!sourceFile.exists()) {
            System.out.println("Source file " + sourceFile.getName() + " does not exist");
            System.exit(2);
        }
        //Check if target file exists
        File targetFile = new File(args[1]);
        if (targetFile.exists()) {
            System.out.println("Target file " + targetFile.getName() + " already exist");
            System.exit(3);
    }
        try (
            //Create input and out file
            Scanner input =  new Scanner(sourceFile);
            java.io.PrintWriter output = new java.io.PrintWriter(targetFile);
                ) {
            while (input.hasNext()) {
                    String str1 = input.nextLine();
                    String str2 = str1.replaceAll(args[2], args[3]);
                    output.println(str2);
                    System.out.println("OldString: " + args[2]);
                    System.out.println("NewString: " + args[3]);
                    System.out.println("ReplacedString: " + str2);
            }
        }
    }      
}
