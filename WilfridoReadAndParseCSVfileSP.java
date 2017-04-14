/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wilfridoreadandparsecsvfilesp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class WilfridoReadAndParseCSVfileSP {
    public static void main(String[] args) {
        String csvFile = "C:/Users/Wilfrido/Desktop/Java-2/CVSFILES/country.csv";
        String line = "";
        String cvsSplitBy = ","; //regular expressions ("\\s+")

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                // Use comma as separator
                String[] country = line.split(cvsSplitBy);
                System.out.println("Country [code= " + country[4] + " , name=" + country[5] + "]");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}