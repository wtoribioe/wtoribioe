/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labschapter1704testbinaryfile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class LabsChapter1704TestBinaryFile {
  
    public static void main(String[] args) throws IOException {
        // Check command-line parameter usage
        if (args.length != 2) {
            System.out.println("Usage: Java Copy sourcefile targetfile");
            System.exit(1);
        }
        // Check if sourcefile exists
        File sourceFile = new File(args[0]);
        if (!sourceFile.exists()) {
            System.out.println("Source file " + args [0] + "dos not exist");
            System.exit(1);
        }
        // Check if target file exists
        File targetFile = new File(args[1]);
        if (targetFile.exists()) {
            System.out.println("Target file " + args[1] + " already exists");
            System.exit(1);
        }
        try (
            // Create an input stream
            // ObjectInputStream input = new ObjectInputStream(new FileInputStream(sourceFile));  //Object-type and primitive-type as well to read/write serializable objects
            BufferedInputStream input = new BufferedInputStream(new FileInputStream(sourceFile)); //Primitive-types and String
                
            // Create an output stream
            // ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(sourceFile));
            BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(sourceFile));
            ){
            // Continously read a byte from input and write it to output
            int r, numberOfBytesCopied = 0;
            while ((r = input.read()) != -1) {
                output.write((byte)r);
                numberOfBytesCopied++;
            }
            // Display the file size
            System.out.println(numberOfBytesCopied + " bytes copied");
        }
                
    }
    
}
