/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wilfridoprocesslargedataset;

import java.util.Comparator;

/** This Assignment #4 Task 12.25 Processing Large Dataset*/
/** Author Wilfrido Toribio Espinosa */
public class EmployeeSalary implements Comparator<EmployeeSalary> {
    String firstName;
    String lastName;
    String rank;
    float salary;
   
    public EmployeeSalary() {
    }
    public EmployeeSalary(String firstName, String lastName, String rank, float salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.rank = rank;
        this.salary = salary;
    }
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getRank(){
        return rank;
    }
    public void setRank(String rank){
        this.rank = rank;
    }
    public float getSalary(){
        return salary;
    }
    //Comparable Interface implementation 
    @Override
    public int compare(EmployeeSalary source, EmployeeSalary target) {
        int field = source.getRank().compareTo(target.getRank());
        return (field != 0) ? field : source.getRank().compareTo(target.getRank());
    }
}
