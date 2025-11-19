/**
 * Tutorial: Abstract Classes
 * Demonstrates abstract classes and methods
 */
abstract class Animal {
    protected String name;
    
    public Animal(String name) {
        this.name = name;
    }
    
    // Abstract method - must be implemented by subclasses
    public abstract void makeSound();
    
    // Abstract method
    public abstract void move();
    
    // Concrete method - can have implementation
    public void eat() {
        System.out.println(name + " is eating");
    }
    
    // Can have instance variables
    public String getName() {
        return name;
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " barks: Woof! Woof!");
    }
    
    @Override
    public void move() {
        System.out.println(name + " runs on four legs");
    }
}

class Bird extends Animal {
    public Bird(String name) {
        super(name);
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " chirps: Tweet! Tweet!");
    }
    
    @Override
    public void move() {
        System.out.println(name + " flies in the sky");
    }
}

public class AbstractClass {
    public static void main(String[] args) {
        // Cannot instantiate abstract class
        // Animal animal = new Animal("Generic"); // Error
        
        Animal dog = new Dog("Buddy");
        Animal bird = new Bird("Tweety");
        
        dog.eat();
        dog.makeSound();
        dog.move();
        
        System.out.println();
        
        bird.eat();
        bird.makeSound();
        bird.move();
    }
}













