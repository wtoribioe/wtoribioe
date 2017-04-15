/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labschapter1708testobjectfile;

import java.io.IOException;
import java.io.RandomAccessFile;

public class LabsChapter1708TestObjectFile {

    public static void main(String[] args)throws IOException {
        // CCreate a random access file for input/output read/write operation
        try (RandomAccessFile input = new RandomAccessFile("inout.dat","rw");
        ){
          // Create the file to destroy the old contents if exists
          input.setLength(0);
          
          // Write new integers to the file
          for (int i = 0; i < 200; i++) // 200 by 4 equal 800 
              input.writeInt(i);
          
          // Print out the integers that were written to the file
          for (int i = 0; i < input.length(); i++)
              System.out.print(i + " ");
           System.out.println(" ");
           
           // Display the current length of the file
           System.out.println("Current file length is " + input.length());
           
            // Retrieve the first number
           input.seek(0);
           System.out.println("The first number is " + input.readInt());
           
            // Retrieve the second number
           input.seek(1 * 4);
           System.out.println("The second number is " + input.readInt());
           
           // Retrieve the tenth number
           input.seek(9 * 4);
           System.out.println("The tehnth number is " + input.readInt());
           
           // Modified the eleventh number
           input.writeInt(555);
           
           // Append a new number
           input.seek(input.length());
           input.writeInt(9999);
           
           // Display the new length
           System.out.println("The new length is " + input.length());
           
           // Retrieve the new eleventh number
           input.seek(10 * 4);
           System.out.println("The eleventh number is " + input.readInt());
        }
    }
}
