package VehicleManagement;

public class VehicleManagementDemo {
    public static void main(String[] args) {
        System.out.println("=== Vehicle Management Demo ===\n");
        
        // Creating different vehicles
        Vehicle car = new Car("Toyota", "Camry", 2022, "Blue", 15.0, 4, "Automatic", true);
        Vehicle motorcycle = new Motorcycle("Honda", "CBR500R", 2021, "Red", 4.5, "Parallel Twin", false, 471);
        
        // Display vehicle information
        System.out.println("=== Vehicle Information ===");
        car.displayInfo();
        motorcycle.displayInfo();
        
        // Start vehicles
        System.out.println("=== Starting Vehicles ===");
        car.start();
        motorcycle.start();
        
        // Drive/Ride vehicles
        System.out.println("\n=== Driving/Riding Vehicles ===");
        ((Car) car).drive(50.0);
        ((Motorcycle) motorcycle).ride(30.0);
        
        // Refuel vehicles
        System.out.println("\n=== Refueling Vehicles ===");
        car.refuel(5.0);
        motorcycle.refuel(2.0);
        
        // Perform maintenance
        System.out.println("\n=== Performing Maintenance ===");
        car.performMaintenance();
        motorcycle.performMaintenance();
        
        // Stop vehicles
        System.out.println("\n=== Stopping Vehicles ===");
        car.stop();
        motorcycle.stop();
        
        // Demonstrating polymorphic behavior
        System.out.println("\n=== Polymorphic Vehicle Operations ===");
        Vehicle[] vehicles = {car, motorcycle};
        for (Vehicle v : vehicles) {
            v.displayInfo();
        }
    }
} 