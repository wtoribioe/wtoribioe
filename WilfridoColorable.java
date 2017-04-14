/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wilfridocolorable;
/** Assignment #5 13.7 colorable Interface ***********
**  Author: Wilfrido Toribio Espinosa *********************
*********************************************************/

public class WilfridoColorable {
    public static void main(String[] args) throws NullPointerException{
        
        //Instantiating the array of objects with defaul and specified values as well.
        GeometricObject[] geomObjArray = new GeometricObject[6];

        geomObjArray[0] = new Circle();
        geomObjArray[1] = new Circle(45.3, "Yellow", true);
        geomObjArray[2] = new Rectangle();
        geomObjArray[3] = new Rectangle(92.2, 80.3, "Blue" , true);
        geomObjArray[4] = new Square();
        geomObjArray[5] = new Square(90.5,90.40,25.60,"Green", false);
        
        //Looping through the array if and instance of Colorable is positive then howToColor method is performed
        for (int i = 0; i < geomObjArray.length; i++) {
            System.out.println("Object Nro.: " + (i + 1) + ". The area is:  " + 
                geomObjArray[i].getArea() + ". The perimeter is:  " + geomObjArray[i].getPerimeter());
        // System.out.println("");
            if (geomObjArray[i] instanceof Colorable) {
                System.out.println("How to Color: " + ((Colorable)geomObjArray[i]).howToColor() + 
                    " With the Color: " + geomObjArray[i].getColor());
                System.out.println("");
            }
        }
    }
}
 