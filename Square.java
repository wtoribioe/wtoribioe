/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wilfridocolorable;
/** Assignment #5 13.7 colorable Interface ***********
**  Author: Wilfrido Toribio Espinosa *********************
*********************************************************/
 
class Square extends GeometricObject implements Colorable {
     //Data fields 
    private double x;
    private double y;
    private double side;

    // Non-args constructor with default arguments
    public Square() {
        this(10.5,10.5,10.5);
    }
    
    //Args constructor with specified arguments
   public Square(double x, double y, double side) {
        this.x = x;
        this.y = y;
        this.side = side;
    }
     public Square(double x, double y, double side, String color, boolean filled) {
        this.x = x;
        this.y = y;
        this.side = side;
        super.setColor(color);     // method calls from super class
        super.setFilled(filled);  // method  calls from super class
   }
     public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public double getPerimeter() {
        return side * 4;
    }
    
    @Override
    public String howToColor() {
        return "Colored all four sides of the Square";
    }

}   
