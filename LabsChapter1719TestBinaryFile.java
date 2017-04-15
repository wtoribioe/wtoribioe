/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labschapter1719testbinaryfile;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class LabsChapter1719TestBinaryFile {
     public static void main(String[] args) throws java.io.IOException{
         
        try (DataOutputStream output = new DataOutputStream(new FileOutputStream("text.txt"));) {
            output.writeInt(1234);
            output.writeInt(5678);
            output.writeChar('A');
            output.writeChars("BC");
            output.writeUTF("DEF");
            output.close();
        }
        
     }
}
