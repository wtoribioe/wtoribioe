/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labschapter1807recursivedirectorysize;

import java.io.File;
import java.util.Scanner;

public class LabsChapter1807RecursiveDirectorySize {

    public static void main(String[] args) {
        // Prompt the user to enter a directory or a file
        System.out.print("Enter directory or a file: ");
        Scanner input = new Scanner(System.in);
        String directory = input.nextLine();
        
        //Display the size
        System.out.println(getSize(new File(directory)) + " bytes");
    }
    public static long getSize(File file){
        long size = 0;  //Store the toal size of all files
        
        if (file.isDirectory()) {
            File[] files = file.listFiles(); //All files and subdirectories
            for (int i = 0; files != null && i < files.length; i++) {
                size += getSize(files[i]);  //recursive call
            }
        }
        else {    //Base case
            size += file.length();
        }
        return size;
    }
}
