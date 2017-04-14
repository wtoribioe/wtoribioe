/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wilfridocolorable;
/** Assignment #5 13.7 colorable Interface ***********
**  Author: Wilfrido Toribio Espinosa *********************
*********************************************************/

class Rectangle extends GeometricObject implements Colorable{
    
    //Data fields
    private double width;
    private double height;
    
    //**Default non args Constructor
    public Rectangle() {
        this(3,4);
    }
    //** Constructor for specified Rectancle using their own datafile plus iheriting the default one defined in the supperclass
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    //** Constructor for specified Rectancle allowing to change all datafiles for both subclass and superclass values */
    public Rectangle(double width, double height, String color, boolean filled) {
        this.width = width;
        this.height = height;
        super.setColor(color);     // method 
        super.setFilled(filled);  // method 
   }
    //** Return width */
    public double getWidth(double width) {
        return width;
    }
    //** set a new width */
    public void setWidth(double width) {
        this.width = width;
    }
    //**Return height */
    public double getHeight(double height){
        return height;
    }
    //** Set a new height */
    public void setHeight(double height){
        this.height = height;
    }
    //** Return area */
    @Override
    public double getArea() {
        return width * height;
    }
    //** Retun Perimeter */
    @Override
    public double getPerimeter(){
        return 2 * (width + height);
    }
    @Override
    public String howToColor() {
        return "Colored all four sides of the Rectangle.";
    }
}