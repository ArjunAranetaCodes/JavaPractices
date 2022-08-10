class Vehicle {
    void start() {
        System.out.println("Vehicle starting...");
    }
}

class Car extends Vehicle {
    void drive() {
    }
}

public class Main {
    public static void main(String[] args) {

        if (myCar instanceof Car) {
        } else {
            System.out.println("Not a valid operation on this vehicle type");
        }
    }
}
