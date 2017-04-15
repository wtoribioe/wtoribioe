/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labschapter1217;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

class EmployeeSalary {
   String firstName;
   String lastName;
   String rank;
   double salary;
   
    public EmployeeSalary(String firstName, String lastName, String rank, double salary) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.rank = rank;
      this.salary = salary;
    }
}
class EmployeeComparator implements Comparator<EmployeeSalary> {
      @Override
      public int compare(EmployeeSalary source, EmployeeSalary target) {
         int field = source.rank.compareTo(target.rank);
         return (field != 0) ? field : source.rank.compareTo(target.rank);
      }
 }
public class TestEmployee {
public static void main(String args[]) {
    ArrayList<EmployeeSalary> list = new ArrayList<>(Arrays.asList(
      new EmployeeSalary ("FirstName1", "LastName1", "assistant", 79174.73),
      new EmployeeSalary ("FirstName2", "LastName2", "associate", 70817.75),
      new EmployeeSalary ("FirstName4", "LastName4", "full", 116992.43),
      new EmployeeSalary("FirstName11", "LastName11", "associate", 74674.29)));

    System.out.println("Unsorted");
    for(EmployeeSalary source : list) {
      System.out.println(source.firstName + " " + source.lastName + ", " + 
                source.rank + ", " + source.salary);
    }
    Collections.sort(list, new EmployeeComparator());

    System.out.println("Sorted");
    for (EmployeeSalary source : list) {
        System.out.println(source.firstName + " " + source.lastName + ", " + 
                source.rank + ", " + source.salary);
    }
  }
}

           