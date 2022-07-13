public class Main {
    public static void main(String[] args) {
        // Instantiating a class with parameterized constructor using the new keyword
        Car myCar = new Car("Toyota", "Camry");
        
        // Accessing and printing the details of the car
        System.out.println("Car Details: " + myCar.getDetails());
    }
}

class Car {
    String make;
    String model;

    public Car(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public String getDetails() {
        return make + " " + model;
    }
}
