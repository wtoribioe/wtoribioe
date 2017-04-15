/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labschapter1323clonable;

public class Labschapter1323Cloneable {
    public static void main(String[] args) {
        
        Edible stuff =  new Chicken();
        eat(stuff);
        
        stuff =  new Duck();
        eat(stuff);
        
        stuff = new  Brocoli();
        eat(stuff);
    }
    public static void eat(Edible stuff) {
        stuff.howToEat();
    }
    interface Edible {
        public String howToEat();    
        }
    class Chicken implements Edible {
         @Override
         public String howToEat() {
            return " Fry it";
         }
    class Duck implements Edible {
         @Override
         public String howToEat() {
            return " Roast it";
         }
    class Brocoli implements Edible {
         @Override
         public String howToEat() {
            return " Stir-fry it";
         }
    }
 