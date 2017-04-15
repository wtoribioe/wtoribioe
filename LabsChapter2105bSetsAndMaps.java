/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labschapter2105bsetsandmaps;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedHashSet;
import java.util.Set;

public class LabsChapter2105bSetsAndMaps {

    public static void main(String[] args) throws Exception {
       ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("test.dat"));
      // LinkedHashSet<String> set1 = new LinkedHashSet<>();
       Set<String> set1 = new LinkedHashSet<>();
     // LinkedHashSet<String> set2 = (LinkedHashSet<String>)(set1.clone());  //Wrogn statement
       LinkedHashSet<String> set2 = (LinkedHashSet<String>)(set1);
       set1.add("Atlanta");
       output.writeObject(set1);
       output.writeObject(set2);
       output.close();
    }
}
