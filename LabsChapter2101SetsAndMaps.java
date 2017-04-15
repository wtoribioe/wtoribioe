/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labschapter2101setsandmaps;

import java.util.HashSet;
import java.util.Set;

public class LabsChapter2101SetsAndMaps {

    public static void main(String[] args) {
        //Create a hashset which will store nonduplicate elements 
        Set<String> set = new HashSet<>();   //Set<> is an interface and HashSet<> is a concrete class
        //Add string to the set
        set.add("London");
        set.add("Paris");
        set.add("New York");
        set.add("San Francisco");
        set.add("Beijing");
        set.add("New York");
        set.add("Beijing");
        
        System.out.println("\nDuplicate element will be eliminated");
        System.out.println(set);
        System.out.println();
        //Display the elements in the hashset uppercase using functional option with lambda expression
        set.stream().forEach((str) -> {
            System.out.println(str.toUpperCase() + " ");
        });
        System.out.println();
        //Display the elements in the hashset uppercase
        for (String str : set) {
            System.out.println(str.toUpperCase() + " ");
        }
    }
}
