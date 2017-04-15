/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labschapter1721testbinaryfile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import org.omg.CORBA.DataInputStream;

public class LabsChapter1721TestBinaryFile {
    public static void main(String[] args) throws FileNotFoundException {
        
        DataBufferedInputStream input1 = new DataBufferedInputStream(new FileInputStream("temp.dat")); //wrong
        
        DataOutputStream output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("temp.dat"))); //correct
        
        DataInputStream input2 = new DataInputStream(new BufferedInputStream(new FileInputStream("temp.dat"))); //correct
    }
}
