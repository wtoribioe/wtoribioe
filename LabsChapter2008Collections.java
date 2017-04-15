/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labschapter2008collections;

import java.util.Collections;
import java.util.PriorityQueue;

public class LabsChapter2008Collections {

    public static void main(String[] args) {
        // PriorityQueue elements are ordered according to natural order using comparable
        PriorityQueue<String> queue1 = new PriorityQueue<>();
        queue1.offer("Oklahoma");
        queue1.offer("Indiana");
        queue1.offer("Georgia");
        queue1.offer("Texas");
        
        System.out.println("\nPriorityQueue elements are ordered according to natural order using comparable");
        System.out.println();
        while (queue1.size() > 0) {
            System.out.println(queue1.remove() + " ");
        }
        // PriorityQueue elements are ordered according to natural order using comparator
        PriorityQueue<String> queue2 = new PriorityQueue<>(4,Collections.reverseOrder());
        queue2.offer("Oklahoma");
        queue2.offer("Indiana");
        queue2.offer("Georgia");
        queue2.offer("Texas");
        
        System.out.println("\nPriorityQueue elements are ordered according to natural order using comparator");
        System.out.println();
        while (queue2.size() > 0){
            System.out.println(queue2.remove() + " ");
        }
    }
} 