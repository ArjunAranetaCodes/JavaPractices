package VehicleManagement;

public class Car extends Vehicle {
    private int numberOfDoors;
    private String transmissionType;
    private boolean hasAirConditioning;
    
    public Car(String make, String model, int year, String color, 
               double maxFuelCapacity, int numberOfDoors, String transmissionType, 
               boolean hasAirConditioning) {
        super(make, model, year, color, maxFuelCapacity);
        this.numberOfDoors = numberOfDoors;
        this.transmissionType = transmissionType;
        this.hasAirConditioning = hasAirConditioning;
    }
    
    @Override
    public boolean start() {
        if (!hasFuel()) {
            System.out.println("Car: Cannot start - no fuel");
            return false;
        }
        
        System.out.println("Car: Starting engine...");
        setRunning(true);
        consumeFuel(0.1); // Small amount of fuel for starting
        System.out.println("Car: Engine started successfully");
        return true;
    }
    
    @Override
    public boolean stop() {
        if (!isRunning) {
            System.out.println("Car: Already stopped");
            return false;
        }
        
        System.out.println("Car: Stopping engine...");
        setRunning(false);
        System.out.println("Car: Engine stopped");
        return true;
    }
    
    @Override
    public boolean refuel(double amount) {
        if (amount <= 0) {
            System.out.println("Car: Invalid fuel amount");
            return false;
        }
        
        double oldLevel = fuelLevel;
        addFuel(amount);
        System.out.println("Car: Refueled " + (fuelLevel - oldLevel) + " gallons");
        return true;
    }
    
    @Override
    public String getVehicleType() {
        return "Car";
    }
    
    @Override
    public double getFuelEfficiency() {
        return 25.0; // Average car fuel efficiency
    }
    
    @Override
    public boolean performMaintenance() {
        System.out.println("Car: Performing maintenance...");
        System.out.println("Car: Checking engine, brakes, and transmission");
        System.out.println("Car: Maintenance completed");
        return true;
    }
    
    // Car-specific method
    public void drive(double distance) {
        if (!isRunning) {
            System.out.println("Car: Cannot drive - engine not running");
            return;
        }
        
        double fuelNeeded = distance / getFuelEfficiency();
        if (fuelLevel >= fuelNeeded) {
            consumeFuel(fuelNeeded);
            updateMileage(distance);
            System.out.println("Car: Drove " + distance + " miles");
        } else {
            System.out.println("Car: Not enough fuel to drive " + distance + " miles");
        }
    }
    
    public int getNumberOfDoors() {
        return numberOfDoors;
    }
    
    public String getTransmissionType() {
        return transmissionType;
    }
    
    public boolean hasAirConditioning() {
        return hasAirConditioning;
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Doors: " + numberOfDoors);
        System.out.println("Transmission: " + transmissionType);
        System.out.println("Air Conditioning: " + hasAirConditioning);
    }
} 