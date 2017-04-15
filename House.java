/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labschapter1322clonable;
public class House  implements Cloneable, Comparable<House>{
    private int id;
    private double area;
    java.util.Date whenBuilt;
    
    public House (int id, double area) {
        this.id = id;
        this.area = area;
        whenBuilt = new java.util.Date();
    }
    public int getId() {
        return id;
    }
    public double getArea() {
        return area;
    }
    public java.util.Date getWhenBuilt(){
        return whenBuilt;
    }
    /*Override the protected clone metho defined in the Object class, and strengthen its accessibility
    Shallow copy and Deep Copy*/
    @Override 
    public Object clone() throws CloneNotSupportedException {
      //  return super.clone();
        //Perform Shallow Copy
          House houseClone = (House)super.clone();
        //Perform Deep Copy on WhenBuilt
          houseClone.whenBuilt = (java.util.Date)(whenBuilt.clone());
          return houseClone;
    }
    @Override //Implement the comparable method defined in Comparable
    public int compareTo(House obj) {
        if (area > obj.area)
            return 1;
        else if (area < obj.area)
            return -1;
        else
            return 0;
    }
}
