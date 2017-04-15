/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labschapter2107setsandmaps;

import java.io.File;
import static java.lang.reflect.Array.set;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LabsChapter2107SetsAndMaps {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a java source file: ");
        String filename = input.nextLine();
        
        File file = new File(filename);
        if (file.exists()) {
            System.out.println("The file number of keywords in " + filename + " is " + countKeywords(file));
        }
        else {
            System.out.println("File " + filename + " does not exist");
        }
    }
    public  static int countKeywords(File file) throws Exception {
        //Array of all java keywords + true, false and null
        String[] keywordsString = {"abstract","assert","boolean","brak","bayte","case","catch","char","class",
            "const","continue","default","do","double","else","enum","extends","for","final","finally","float",
            "goto","if","implements","import","instanceof","int","interface","long","return","native","new",
            "package","private","protected","public","short","static","strictfp","super","switch","synchronized",
            "this","throw","throws","transient","try","void","volatile","while","true","false","null"};
       
        Set<String> keywordSet = new HashSet<>(Arrays.asList(keywordsString));
        int count = 0;
        
        Scanner input = new Scanner(file);
        while (input.hasNext()) {
            String word = input.next();
            if (keywordSet.contains(word))
                count++;
        }
        return count;
    }
}
