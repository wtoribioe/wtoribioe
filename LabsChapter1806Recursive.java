/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labschapter1806recursive;

public class LabsChapter1806Recursive {

    public static int recursiveBinarySearch(int[] list, int key) {
        int low = 0;
        int high = list.length - 1;
        return recursiveBinarySearch(list,key,low,high);
    }
     public static int recursiveBinarySearch(int[] list, int key, int low, int high) {
    if (low > high) 
        return -low -1;
    
    int mid = (low + high) / 2;
    if (key < list[mid])
        return recursiveBinarySearch(list,key,low,mid -1);
    else if (key == list[mid])
        return mid;
    else
        return recursiveBinarySearch(list,key,mid + 1,high);
   }
}