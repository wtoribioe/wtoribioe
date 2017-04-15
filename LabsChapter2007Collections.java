/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labschapter2007collections;

import java.util.LinkedList;
import java.util.Queue;

public class LabsChapter2007Collections {

    public static void main(String[] args) {
        //Queue first-in, first-Out order elements
        Queue<String> queue = new LinkedList<>();
        queue.offer("Oklahoma");
        queue.offer("Indiana");
        queue.offer("Georgia");
        queue.offer("Texas");
        
        System.out.println("\nQueue first-in, first-Out order elements");
        System.out.println();
        while (queue.size() > 0)
            System.out.println(queue.remove() + " ");
    }
}
