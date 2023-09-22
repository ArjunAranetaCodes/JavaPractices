class Vehicle {
    String brand;
    String model;

    Vehicle(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
    }
}

class Car extends Vehicle {
    int numDoors;

    Car(String brand, String model, int numDoors) {
        super(brand, model);
        this.numDoors = numDoors;
    }

    void displayCarInfo() {
        displayInfo();
        System.out.println("Number of Doors: " + numDoors);
    }
}

class Motorcycle extends Vehicle {
    boolean hasSideCar;

    Motorcycle(String brand, String model, boolean hasSideCar) {
        super(brand, model);
        this.hasSideCar = hasSideCar;
    }

    void displayMotorcycleInfo() {
        displayInfo();
        System.out.println("Has Side Car: " + hasSideCar);
    }
}

public class VehicleTest {
    public static void main(String[] args) {
        Car car = new Car("Toyota", "Camry", 4);
        car.displayCarInfo();

        Motorcycle motorcycle = new Motorcycle("Harley-Davidson", "Sportster", false);
        motorcycle.displayMotorcycleInfo();
    }
}
