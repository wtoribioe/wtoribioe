/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labschapter1707testobjectfile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class LabsChapter1707TestObjectFile {
    
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        
        int[] numbers = {1,2,3,4,5,6,7,8,9};
        String[] strings = {"Jesus","Lizandro","Gabriela","Dorian","Kim","Pam"};
        
        // Create an output stream for file array.dat
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("array.dat"));
        ){
        // Write arrays to the object output stream
            output.writeObject(numbers);
            output.writeObject(strings);    
        }
        //Create an input stream for file array.dat
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("array.dat"))
        ){
            int[] newNumbers = (int[])(input.readObject()); //Casting 
            String[] newStrings = (String[])(input.readObject()); //Casting
            
        // Display numeric array
            System.out.println("Numeric Array ");
            for (int i = 0; i < newNumbers.length; i++)
               System.out.print(newNumbers[i] + " ");
            
            System.out.println("\n");
            
        // Display strings array
            System.out.println("Strings Array ");
            for (int i = 0; i < newStrings.length; i++)
               System.out.print(newStrings[i] + " ");
            
            System.out.println("\n");
        }
    }  
}
