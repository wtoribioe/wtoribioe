/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labschapter1217;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LabsChapter1217 {
    public static void main(String[] args) throws IOException, Exception {
        System.out.print("Enter a URL: ");
        String URLString = new Scanner(System.in).next();
        String path = "C:/Users/Wilfrido/Desktop/Java-2/LabsChapter1217/Salary.txt";
        java.io.File file = new java.io.File(path);
        if (file.exists()) {
            System.out.println("Local file: " + file.getName() + " exist");
            //Creating the file
            deleteFile(file);
            System.out.println(" ");
        }
        try {
            java.net.URL url = new java.net.URL(URLString);
            int count = 0;
            Scanner input = new Scanner(url.openStream());
            ArrayList<String> salaryList = new ArrayList<>();
            try (java.io.PrintWriter output = new java.io.PrintWriter(file)) {
                while (input.hasNext()) {
                    String line =  input.nextLine();
                    System.out.println(line);
                    output.println(line);
                    salaryList.add(line);
                    count += line.length();
                }
                System.out.println(" ");
                System.out.println("The file size is " + count + " characters");
                System.out.println("Located at " + file.getAbsolutePath());
                System.out.println("Last modified on " + new java.util.Date(file.lastModified()));
                System.out.println(" ");
                System.out.println(salaryList);
                System.out.println(salaryList.size());
            }
        }
        catch (java.net.MalformedURLException ex) {
            System.out.println("Invalid URL");
        }
        catch (java.io.IOException ex) {
            System.out.println("I/O Errors no such file -Invalid URL)-");
        }
    }
    public static void deleteFile(File file) throws Exception {
        String path = "C:/Users/Wilfrido/Desktop/Java-2/LabsChapter1217/Salary.txt";
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
