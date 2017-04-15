/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labschapter138sortcomparableobjects;

import java.math.BigInteger;

public class LabsChapter138SortComparableObjects {
    public static void main(String[] args) {
        String[] cities = {"Savannah","Boston","Atlanta","Tampa"};
        java.util.Arrays.sort(cities);
        for (String city : cities) 
            System.out.println(city + " ");
        System.out.println();
        
        BigInteger[] hugeNumbers = {new BigInteger("232323232302020202"),
                                    new BigInteger("432323232302020202"),
                                    new BigInteger("542323232302020202")};
        java.util.Arrays.sort(hugeNumbers);
        for (BigInteger number : hugeNumbers) 
            System.out.println(number + " ");
        System.out.println();
        }
    }
    
