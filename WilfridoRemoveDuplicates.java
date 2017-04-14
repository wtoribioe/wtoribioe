/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wilfridoremoveduplicates;

/** Assignment #3 Task 11.13 Remove Duplicated values in Array List ***********
**  Author: Wilfrido Toribio Espinosa *********************
*********************************************************/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class WilfridoRemoveDuplicates {
    public static void main(String[] args) {
        ArrayList<Integer> integerList = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter ten integers (input END with 0): ");
        int value;
        //Read 10 values from the input
        do {
                 value = input.nextInt(); 
                 integerList.add(value); //Add the value if it is not in the list
       } while (value != 0);
       
        //Print the entered array with duplicated values on the list
        System.out.println("The ten integer are: " + integerList + " ");
        System.out.println(" ");
        
        //Remove the duplicted values if there is any in the array list
        Object[] integer = integerList.toArray();
        for (Object in : integer) {
            if (integerList.indexOf(in) != integerList.lastIndexOf(in)) {
            integerList.remove(integerList.lastIndexOf(in));
         }
      }
            System.out.println("The distinct integer are: " + integerList + " ");
  }
}