abstract class Vehicle {
    abstract void start();

    void stop() {
        System.out.println("Vehicle stopped");
    }
}

class Car extends Vehicle {
    void start() {
        System.out.println("Car started");
    }
}

class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.start();
        car.stop();
    }
}
