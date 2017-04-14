/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wilfridomyinteger;

import java.util.Scanner;

/** Assignment #2 Task 10.3 ***********
**Author: Wilfrido Toribio Espinosa ***
**************************************/

public class WilfridoMyInteger {
    public static void main(String[] args) {
        //****************************************
        // ***Capture the primitive Int value ****
        //****************************************
        System.out.println("          Processing (int) primitive data type value with primitive methods.");
        System.out.println("Then wrapping the primitive data type value into an object and using Overloaded methods.");
        System.out.println("********************************************************************************");
        System.out.println("     *******************************************************************");
        System.out.println("             ***************************************************");
        System.out.println("                   **************************************");
        System.out.println("                           ***********************");
        System.out.println("                                *************");
        System.out.println("                                   *******");
        System.out.println("                                      **");
        System.out.println(" ");
        Scanner input = new Scanner(System.in);
	System.out.print("Enter an integer number :");
	int value = input.nextInt();
        System.out.println(" ");
        
       	//*************************************************************************
        //****Instantiating the object passing to the constructor the (Int) value**
        //*************************************************************************
        MyInteger number = new MyInteger(value);
        Integer valueObject = number.value;
        
        //*************************************************************
        //***If isEven method retrun true then the number is even******
        //*************************************************************
	if(number.isEven(value) == true & number.isEven(valueObject) == true){
            System.out.println("The Integer Value :" + number.value + " is Even"); 
    } 
        
        //***********************************************************
        //***If isOdd method return true then the number is Odd******
        //***********************************************************
	if(number.isOdd(value) == true & number.isOdd(valueObject) == true){
            System.out.println("The Integer Value :" + number.value + " is Odd");   
    }
        
        //******************************************************************
        //*****If isPrime method return true then the number is prime*******
        //******************************************************************
	if(number.isPrime(value) == true & number.isPrime(valueObject) == true){
            System.out.println("The Integer Value :" + number.value + " is Prime");  
    }
        
        //****************************************************************
        //****If isEquals method return true then the number is equals****
        //****************************************************************
	if(number.isEquals(value) == true & number.isEquals(valueObject) == true){
            System.out.println("The Integer value :" + number.value + " is Equals");
        }
        System.out.println(" ");
        System.out.println("***Wrapped Primitive(int) to Non-Primitive(Integer) ***");
        System.out.println(" ");
        
        //****************************************************************************
        //****Integer number returned from the Method pasrseInt numeric Array Char****
        //****************************************************************************
        char[] numericArray = null;
        MyInteger.parseInt(numericArray);
   
        //***********************************************************************
        //***Integer number returned from the Method pasrseInt numeric String***
        //**********************************************************************
        String string = null;
        MyInteger.parseInt(string);
 }
}
