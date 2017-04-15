/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labschapter1704atestbinaryfile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class LabsChapter1704aTestBinaryFile {
    /* Main methdo
    @param args[0] for source file
    @param args[1] for target file
    */
    public static void main(String[] args) throws IOException {

        File sourceFile = new File("C:/Users/Wilfrido/Desktop/Java-2/LabsChapter1704TestBinaryFile/sourcefile");
        if (!sourceFile.exists()) {
            System.out.println("Source file " + sourceFile.getName() + "dos not exist");
            System.exit(1);
        }
        File targetFile = new File("C:/Users/Wilfrido/Desktop/Java-2/LabsChapter1704TestBinaryFile/targetfile");
        if (targetFile.exists()) {
            System.out.println("Target file " + targetFile.getName() + " already exists");
            System.exit(1);
        }
        try (
            // Create an input stream
            BufferedInputStream input = new BufferedInputStream(new FileInputStream(sourceFile));
                
            // Create an output stream
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
