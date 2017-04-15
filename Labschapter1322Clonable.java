/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labschapter1322clonable;

import java.util.ArrayList;
import java.util.Date;

public class Labschapter1322Clonable {
    public static void main(String[] args) throws CloneNotSupportedException {
        
        boolean result;
        House house1 = new House(1,1750.50);
        House house11 = (House)house1.clone();
        result = house1.whenBuilt == house11.whenBuilt;
        System.out.println("house1.whenBuilt == house11.whenBuilt is " + result);
         
        System.out.println("---------------------------------------------");
        House house2 = new House(1,2850.50);
        House house22 = (House)house2.clone();
        result = house2.whenBuilt == house22.whenBuilt;
        System.out.println("house2.whenBuilt == house22.whenBuilt is " + result);
        
        System.out.println("---------------------------------------------");
        java.util.Date date = new java.util.Date(); 
        java.util.Date date1 = date;
        java.util.Date date2 = (java.util.Date)date.clone(); 
        System.out.println(date == date1);
        System.out.println(date == date2);
        System.out.println(date.equals(date2));
        
        System.out.println("---------------------------------------------");
        ArrayList<String> list = new ArrayList<>();
        list.add("New Yourk");
        
        ArrayList<String> list1 = list;
        ArrayList<String> list2 = (ArrayList<String>)(list.clone());
        list.add("Atlanta");
        
        System.out.println(list == list1);
        System.out.println(list == list2);
        
        System.out.println("list is " + list);
        System.out.println("list1 is " + list1);
        System.out.println("list2.get(0) is " + list2.get(0));
        System.out.println("list2.size() is " + list2.size());
    }
}
