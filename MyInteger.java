/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wilfridomyinteger;

import java.util.Arrays;

/** Assignment #2 Task 10.3 ************
***Author: Wilfrido Toribio Espinosa ***
***************************************/

public class MyInteger {
    int value;
   
//****************************************************************
//***** Single argument Constructeor for Primitive int value******
//****************************************************************
public MyInteger(int value){
    this.value = value;
  }

//******************************************************************************
//*****Single argument Constructor for Non-Primitive Integer value (Wrapper)****
//******************************************************************************
public MyInteger(Integer valueObject){
    //***AutoBoxing int value***
    Integer intObject = this.value;
}

//******************************************************************
//*****Single argument Constructor for character numeric array *****
//******************************************************************
public MyInteger(char[] chr) {
    char[] numericArray = {'1','2','5','1','9','6','1'};   
}

//*************************************************
//*****Single argument Constructor for String  ****
//*************************************************
public MyInteger(String str) {
    String string = new String("123456789");   
}

public void setValue(int value) {
    this.value = value;
}

public boolean isEven(int value) {
    return this.value % 2 == 0;  
 }

public boolean isOdd(int value) {
    return this.value % 2 != 0;  
  }

public boolean isPrime(int value) {
    int temp;
    boolean isPrime = true;
    for(int i = 2; i <= this.value / 2; i++){
           temp = this.value % i;
	   if(temp == 0){
	      isPrime =  false;
	      break;
	   }
	}
        return isPrime;
   }

public boolean isEquals(int value) {
    int temp;
    boolean isEquals = false;
    for(int i = 2; i <= this.value / 2; i++){
           temp = this.value % i;
	   if(temp == 0){
	      isEquals =  true;
	      break;
	   }
	}
        return isEquals;
   }

//******************************
//**** Method Overloading ******
//******************************
public void setValue(Integer intObject) {
    //***AutoBoxing***
    intObject = this.value;
}

public boolean isEven(Integer intObject) {
    //***AutoBoxing***
    intObject = this.value;
    return intObject % 2 == 0;  
 }

public boolean isOdd(Integer  intObject) {
    //***AutoBoxing***
    intObject = this.value;
    return intObject % 2 != 0;  
  }

public boolean isPrime(Integer intObject) {
        //***AutoBoxing***
    intObject = this.value;
    
    int temp;
    boolean isPrime = true;
    for(int i = 2; i <= intObject / 2; i++){
           temp = intObject % i;
	   if(temp == 0){
	      isPrime =  false;
	      break;
	   }
	}
        return isPrime;
   }

public  boolean isEquals(Integer intObject) {
    //***AutoBoxing***
    intObject = this.value;
    
    int temp;
    boolean isEquals = false;
    for(int i = 2; i <= intObject / 2; i++){
           temp = intObject % i;
	   if(temp == 0){
	      isEquals =  true;
	      break;
	   }
	}
        return isEquals;
  }

public static void parseInt(char[] chr){
    char[] numericArray = {'1','2','5','1','9','6','1'};
    int numberChr = Integer.parseInt(String.valueOf(numericArray));
    System.out.println("The Numeric Character array is :" + Arrays.toString(numericArray));
    System.out.println("The Integer Parsed was :" + numberChr);
    System.out.println(" ");
}
public static void parseInt(String str){
    String string = "123456789";
    int numberStr = Integer.parseInt(String.valueOf(string));
    System.out.println("The Numeric String is :" + "'" + string + "'");
    System.out.println("The Integer Parsed was :" + numberStr);
    System.out.println(" ");
    System.out.println("***Parsed (Numeric Array and Numeric String) to Primitive (Int) value***");
    }
}
