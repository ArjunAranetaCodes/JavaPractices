## Problem: 
Creating an Array of Vehicle Objects

## Description: 
Create a program that demonstrates the use of abstract class type arrays to store and manipulate vehicle information.

## Input:

Vehicle information:

Car: make = Toyota, model = Camry, year = 2020

Truck: make = Ford, model = F-150, year = 2018

Motorcycle: make = Harley-Davidson, model = Electra Glide, year = 2022

## Output:

Vehicle array:

Car: make = Toyota, model = Camry, year = 2020

Truck: make = Ford, model = F-150, year = 2018

Motorcycle: make = Harley-Davidson, model = Electra Glide, year = 2022

## Code Answer:
```Java
public abstract class Vehicle {
    private String make;
    private String model;
    private int year;

    public Vehicle(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public abstract double getFuelEfficiency();

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }
}

public class Car extends Vehicle {
    public Car(String make, String model, int year) {
        super(make, model, year);
    }

    public double getFuelEfficiency() {
        return 25.0;
    }
}

public class Truck extends Vehicle {
    public Truck(String make, String model, int year) {
        super(make, model, year);
    }

    public double getFuelEfficiency() {
        return 18.0;
    }
}

public class Motorcycle extends Vehicle {
    public Motorcycle(String make, String model, int year) {
        super(make, model, year);
    }

    public double getFuelEfficiency() {
        return 40.0;
    }
}

public class VehicleArray {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[3];

        vehicles[0] = new Car("Toyota", "Camry", 2020);
        vehicles[1] = new Truck("Ford", "F-150", 2018);
        vehicles[2] = new Motorcycle("Harley-Davidson", "Electra Glide", 2022);

        for (Vehicle vehicle : vehicles) {
            System.out.println("Vehicle: " + vehicle.getMake() + " " + vehicle.getModel() + ", Year: " + vehicle.getYear() + ", Fuel Efficiency: " + vehicle.getFuelEfficiency());
        }
    }
}
```

File Name: VehicleArray.java

This program demonstrates the use of abstract class type arrays to store and manipulate vehicle information. The Vehicle abstract class represents a vehicle, and the Car, Truck, and Motorcycle classes extend the Vehicle class. The VehicleArray class creates an array of Vehicle objects.

Note: Abstract class type arrays are used to store and manipulate objects of different classes that share a common abstract class. This is useful for creating arrays of objects that share a common base class, but have different implementations.