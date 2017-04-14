/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrappertesting;
  
public class ValueOfDemo {  
    public static void main(String[] args) {  
        Integer intWrapper = Integer.valueOf("12345");  
        
        //Converting from binary to decimal  
        Integer intWrapper2 = Integer.valueOf("11011", 2);
        
        //Converting from hexadecimal to decimal  
        Integer intWrapper3 = Integer.valueOf("D", 16);  
        System.out.println("Value of intWrapper Object: "+ intWrapper);  
        System.out.println("Value of intWrapper2 Object: "+ intWrapper2);  
        System.out.println("Value of intWrapper3 Object: "+ intWrapper3);  
        System.out.println("Hex value of intWrapper: " + Integer.toHexString(intWrapper));    
        System.out.println("Binary Value of intWrapper2: "+ Integer.toBinaryString(intWrapper2));  
    }  
}  

      

 


 

 

