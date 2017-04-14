/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * Enter a URL: http://cs.armstrong.edu/liang/data/Salary.txt
 */
package wilfridoprocesslargedataset;
/** This Assignment #4 Task 12.25 Processing Large Dataset*/
/** Author Wilfrido Toribio Espinosa */
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

  public class WilfridoProcessLargeDataset {
    static float associateSalary = 0;
    static float fullSalary = 0;
    static float assistantSalary = 0;
    static String path = "Salary.txt";
    
    public static void main(String args[]) throws  Exception, IOException {
        //Capturing the URL link
        System.out.print("\nEnter a URL: ");
        String URLString = new Scanner(System.in).next();
        java.io.File file = new java.io.File(path);
        
        //Calling methods
        downLoadingFile(file,URLString);
        sortProcessObjectFile(file);
    }
    //Downloading the file from the web to the local directory
    public static void downLoadingFile(File file, String URLString) throws Exception {
        if (file.exists()) {
            System.out.println("Local file: " + file.getName() + " exist");
            //Deleting the file if already exist
            deleteFile(file);
            System.out.println(" ");
        }
        try {
            System.out.println("Downloading the file from the web .......... ");
            System.out.println(" ");
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
            System.out.println("Total Records in the file: " + salaryList.size());
            System.out.println("File downloaded at " + file.getAbsolutePath());
            System.out.println("Last modified on " + new java.util.Date(file.lastModified()));
            System.out.println(" ");
            }
        }
        catch (java.net.MalformedURLException ex) {
            System.out.println("Invalid URL was Entered");
            System.exit(1);
        }
        catch (java.io.IOException ex) {
            System.out.println("I/O Errors no such file-");
        } 
    }
    //Sorting and Processing the file as collection object through the class EmployeeSalary
    public static void sortProcessObjectFile(File file) throws Exception {
        ArrayList<EmployeeSalary> list = new ArrayList<>(Arrays.asList());
        try { 
            System.out.println(" ");
            System.out.println("Converting local file to Collection Object .......\n");
            Scanner input = new Scanner(file);
            while (input.hasNext()) {
                String firstName = input.next();
                String lastName = input.next();
                String rank = input.next();
                float salary = input.nextFloat();
                list.add(new EmployeeSalary(firstName,lastName,rank,salary));
                System.out.println("First Name: " + firstName + ", " + "Last Name: "
                    + lastName + ", " + "Rank: " + rank + ", " + "Salary: " + salary );
            }
        }
        catch (java.io.IOException ex) {
            System.out.println("I/O Errors no such file-");
            System.exit(1);
        }
        System.out.println(" ");
        System.out.println(" --------- Unsorted Collectoion file object -------\n");
        for(EmployeeSalary source : list) {
            System.out.println(source.getFirstName() + " " + source.getLastName() + ", " + 
                source.getRank() + ", " + source.getSalary());
        }
            System.out.println(" ");
            System.out.println("------ Sorted and processed Collection file Object ------\n");
            Collections.sort(list, new EmployeeSalary());
            int countAssis = 0; int countAssoc = 0; int countFull = 0;
                for (EmployeeSalary source : list) {
                   if (null != source.getRank()) switch (source.getRank()) {
                        case "assistant":
                        assistantSalary += source.getSalary();
                        System.out.println(source.getFirstName() + " " + source.getLastName() + ", " + 
                            source.getRank() + ", " + source.getSalary());
                        countAssis++;
                        break;
                        case "associate":
                        associateSalary += source.getSalary(); 
                        System.out.println(source.getFirstName() + " " + source.getLastName() + ", " +
                            source.getRank() + ", " + source.getSalary());
                        countAssoc++;
                        break;
                        case "full":
                        fullSalary += source.getSalary();
                        System.out.println(source.getFirstName() + " " + source.getLastName() + ", " +
                            source.getRank() + ", " + source.getSalary());
                        countFull++;
                        break;
                    }
                }
        System.out.print(String.format("\nTotal Salary Professor Assistant              :\t$%,.2f",assistantSalary));
        System.out.print(String.format("\nTotal Enployee: %d With Average Salary:\t$%,.2f\n",countAssis,(assistantSalary/countAssis)));
        System.out.print(String.format("\nTotal Salary Professor Associate              :\t$%,.2f ",associateSalary));
        System.out.print(String.format("\nTotal Enployee: %d With Average Salary:\t$%,.2f\n",countAssoc,(associateSalary/countAssoc)));
        System.out.print(String.format("\nTotal Salary Professor Full                   :\t$%,.2f ",fullSalary));
        System.out.print(String.format("\nTotal Enployee: %d With Average Salary:\t$%,.2f\n",countFull,(fullSalary/countFull)));
        System.out.println(" ");
        System.out.println("Total Employee processed: " + list.size());
  }
    //Deleting the local file if already exist
    public static void deleteFile(File file) throws Exception {
        try {
            if(file.delete()){
                System.out.println(file.getName() + " file was deleted!");
            }else {
                System.out.println("Delete operation was failed.");
            }
            }catch(Exception e){
       }
   }
}

           