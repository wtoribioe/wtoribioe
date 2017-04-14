/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wilfridocolorable;

/** Assignment #5 13.7 colorable Interface ***********
**  Author: Wilfrido Toribio Espinosa *********************
*********************************************************/
public abstract class GeometricObject {
   
    //Data fields
    String color = "White";
    private boolean filled;
    private java.util.Date dateCreated;

    // Construct a default geometic object
    protected GeometricObject() {
        dateCreated = new java.util.Date();
    }
    //Create a geometric object wht color and filled value
    protected GeometricObject(String color, boolean filled) {
        dateCreated = new java.util.Date();
        this.color = color;
        this.filled = filled;
    }
    //Regurn color
    public String getColor() {
        return color;
    }
    //Set color
    public void setColor(String color) {
        this.color = color;
    }
    //Return new filled
    public boolean getFilled() {
        return filled;
    }
    //Set new filled
    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    //Get datecreated
    public java.util.Date getDateCreated() {
        return dateCreated;
    }
    @Override
    public String toString() {
        return "Creatted on " + dateCreated + "\ncolor: " + color + " and filled: " + filled;
    }
    //Abstract method getArea
    public abstract double getArea();
    
    //Abstract methdo getPerimeter
    public abstract double getPerimeter();
}
