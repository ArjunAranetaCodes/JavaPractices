public class Main {
    public static void main(String[] args) {
        Car myCar = new Car("Toyota", "Camry");
        
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
