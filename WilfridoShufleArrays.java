/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wilfridoshuflearrays;

/** Assignment #3 Task 11.3 Shufle Array List ***********
**  Author: Wilfrido Toribio Espinosa *********************
*********************************************************/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class WilfridoShufleArrays {
    public static void main(String[] args) {
        Integer [] file1 = {2,3,4,5,3,7,8,99,0,76,6,55};
        ArrayList<Integer> file1List = new ArrayList<>(Arrays.asList(file1));

        Integer [] file2 = {100,202,255,145,336,252,88,595};
        ArrayList<Integer> file2List = new ArrayList<>(Arrays.asList(file2));

        //randomized fileList Array
        System.out.println("Before Shuffling first Array");
        System.out.println("----------------------------");
        System.out.print(" ");
        for (Integer temp : file1) {
            System.out.print(temp + " ");
            System.out.print(" ");
            System.out.print(" ");
        }
        System.out.print(" ");
        System.out.println("\nAfter shuffling above Array");
        System.out.println("-----------------------------");
        System.out.print(" ");
        Collections.shuffle(file1List); 
        System.out.println(file1List);
        System.out.print(" ");
        System.out.print(" ");
        
        //randomized imgList Array
        System.out.println("\nBefore shuffling second Array" );
        System.out.println("-------------------------------");
        System.out.print(" ");
        for (Integer temp : file2) {
            System.out.print(temp + " ");
            System.out.print(" ");
        }
        System.out.print(" ");
        System.out.println("\nAfter shuffled above Array");
        System.out.println("-----------------------------");
        System.out.print(" ");
        Collections.shuffle(file2List);
        System.out.println(file2List);
  }
}