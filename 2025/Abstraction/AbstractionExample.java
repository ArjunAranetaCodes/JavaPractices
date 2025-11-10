/**
 * Tutorial: Abstraction Example
 * Demonstrates abstraction with vehicle system
 */
abstract class Vehicle {
    protected String brand;
    protected int year;
    
    public Vehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }
    
    // Abstract methods - must be implemented
    public abstract void start();
    public abstract void stop();
    public abstract void accelerate();
    
    // Concrete method
    public void displayInfo() {
        System.out.println("Brand: " + brand + ", Year: " + year);
    }
}

class Car extends Vehicle {
    public Car(String brand, int year) {
        super(brand, year);
    }
    
    @Override
    public void start() {
        System.out.println("Car engine started");
    }
    
    @Override
    public void stop() {
        System.out.println("Car brakes applied");
    }
    
    @Override
    public void accelerate() {
        System.out.println("Car accelerating");
    }
}

class Motorcycle extends Vehicle {
    public Motorcycle(String brand, int year) {
        super(brand, year);
    }
    
    @Override
    public void start() {
        System.out.println("Motorcycle engine started");
    }
    
    @Override
    public void stop() {
        System.out.println("Motorcycle brakes applied");
    }
    
    @Override
    public void accelerate() {
        System.out.println("Motorcycle accelerating");
    }
}

public class AbstractionExample {
    public static void main(String[] args) {
        Vehicle car = new Car("Toyota", 2023);
        Vehicle motorcycle = new Motorcycle("Honda", 2022);
        
        car.displayInfo();
        car.start();
        car.accelerate();
        car.stop();
        
        System.out.println();
        
        motorcycle.displayInfo();
        motorcycle.start();
        motorcycle.accelerate();
        motorcycle.stop();
    }
}

