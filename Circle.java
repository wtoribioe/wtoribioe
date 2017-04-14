/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wilfridocolorable;
/** Assignment #5 13.7 colorable Interface ***********
**  Author: Wilfrido Toribio Espinosa *********************
*********************************************************/

class Circle extends GeometricObject implements Colorable{
   
    //Data field
    private double radius;
     
    //**Default constuctor that is always placed into the datafile declaration level to inicialize default vaulues
    public Circle() {
         this(1);
     }
    //**Constuctor for specified radius only so it will inherited the default values from the supperclass for color and filled
    public Circle(double radius) {
         this.radius = radius;
     }    
     //**Constuctor for specified radius allowing to change the values from both subclass and superclass datafields 
    public Circle(double radios, String color, boolean filled) {
        this.radius =  radius;
        super.setColor(color);     // method parent class
        super.setFilled(filled);  // method parent class
     }
     //** Return radius */
    public double getRadius() {
         return radius;
     } 
     //** Set a new radius */
    public void seRadius(double radius) {
         this.radius = radius;
     }
     //** Return area */
    @Override
     public double getArea() {
         return   radius * radius * Math.PI;
     }
     //** Return diameter */
     public double getDiameter() {
         return 2 * radius; 
     }
     //** Return Perimeter */
    @Override
     public double getPerimeter() {
         return 2 * radius * Math.PI;
     }
    //** Return color */
    @Override
    public String getColor(){
        return color;
    }
    //** Set a new color */
    @Override
    public void setColor(String color){
        this.color = color;
    }
     //** Print the Circle info */
     public void printCircle() {
     System.out.println("The circle is created " + getDateCreated() + " and the radius is " + radius);
    }
     @Override
    public String howToColor() {
        return "Colored the shape of the Circle";
    }
}