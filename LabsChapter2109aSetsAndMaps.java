/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labschapter2109asetsandmaps;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class LabsChapter2109aSetsAndMaps {
    public static void main(String[] args) {
        Set<String> set = Collections.singleton("Chicago");  
     // set.add("Dallas"); //UnsupportedOperationException at java.util.AbstractCollection.add(AbstractCollection.java:262)
        System.out.println(set); // output [Chicago] statement is correct
        
        //----------------------------------------------------------------------
        List list = Collections.unmodifiableList(Arrays.asList("Chicago", "Boston"));
        System.out.println(list);  // output [Chicago,Boston] statement is correct
    }
}
