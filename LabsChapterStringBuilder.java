/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labschapterstringbuilder;

import java.util.Scanner;

public class LabsChapterStringBuilder {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //**Enter a string
        System.out.print("Enter a string: ");
        String str = input.nextLine();
        //**Display result
        System.out.println("Ignoring nonalfabetic characters. \nl is " 
                + str + " a palindrome? " + isPalindrome(str));  
        
    }
        //**Retrun true if a string is palindrome
    public static boolean isPalindrome(String str){
        //**Create a new string by eliminating nonalphanumeric chars
        String str1 = filter(str);
        
        //**Create a new string that s reversal of str1
        String str2 = reverse(str1);
        
        //**Check if the reversal is the sameas the original string
        return str2.equals(str1);
        
        //**Create a string eliminating nonalphanumeric chars
    }   
    public static String filter(String str){
        //**Create String builder
        StringBuilder stringBuilder = new StringBuilder();
       //**Eximine each char in the string to skip alphanumeric char
        for (int i = 0; i < str.length(); i++){
            if (Character.isLetterOrDigit(str.charAt(i))); 
    }
    //**Return a new filered string
        return stringBuilder.toString();
  }
    //**Create a new string by reversing a specified string
    public static String reverse(String str) {
        StringBuilder stringBuilder =  new StringBuilder(str);
        stringBuilder.reverse(); //invoke reverse method in string builder
        return stringBuilder.toString();
    }
}