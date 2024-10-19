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