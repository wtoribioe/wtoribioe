/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labschapter1323clonable;
abstract class Animal {
    public abstract String howToEat();
    }

class Chicken extends Animal {
    @Override
    public String howToEat() {
        return "Fry it";
    }
}
class Duck extends Animal {
    @Override
    public String howToEat() {
        return "Roast it";
    }
}

public class Labschapter1323Clonable {
    public static void main(String[] args) {
        Animal animal = new Chicken();
        eat(animal);
        
        animal = new Duck();
        eat(animal);
    }
    public static void eat(Animal animal) {
        animal.howToEat();
    }
}