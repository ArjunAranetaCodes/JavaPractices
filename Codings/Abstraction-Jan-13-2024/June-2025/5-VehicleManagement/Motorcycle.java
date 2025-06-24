package VehicleManagement;

public class Motorcycle extends Vehicle {
    private String engineType;
    private boolean hasSidecar;
    private int engineDisplacement;
    
    public Motorcycle(String make, String model, int year, String color, 
                     double maxFuelCapacity, String engineType, boolean hasSidecar, 
                     int engineDisplacement) {
        super(make, model, year, color, maxFuelCapacity);
        this.engineType = engineType;
        this.hasSidecar = hasSidecar;
        this.engineDisplacement = engineDisplacement;
    }
    
    @Override
    public boolean start() {
        if (!hasFuel()) {
            System.out.println("Motorcycle: Cannot start - no fuel");
            return false;
        }
        
        System.out.println("Motorcycle: Starting engine...");
        setRunning(true);
        consumeFuel(0.05); // Small amount of fuel for starting
        System.out.println("Motorcycle: Engine started successfully");
        return true;
    }
    
    @Override
    public boolean stop() {
        if (!isRunning) {
            System.out.println("Motorcycle: Already stopped");
            return false;
        }
        
        System.out.println("Motorcycle: Stopping engine...");
        setRunning(false);
        System.out.println("Motorcycle: Engine stopped");
        return true;
    }
    
    @Override
    public boolean refuel(double amount) {
        if (amount <= 0) {
            System.out.println("Motorcycle: Invalid fuel amount");
            return false;
        }
        
        double oldLevel = fuelLevel;
        addFuel(amount);
        System.out.println("Motorcycle: Refueled " + (fuelLevel - oldLevel) + " gallons");
        return true;
    }
    
    @Override
    public String getVehicleType() {
        return "Motorcycle";
    }
    
    @Override
    public double getFuelEfficiency() {
        return 45.0; // Average motorcycle fuel efficiency
    }
    
    @Override
    public boolean performMaintenance() {
        System.out.println("Motorcycle: Performing maintenance...");
        System.out.println("Motorcycle: Checking engine, chain, and brakes");
        System.out.println("Motorcycle: Maintenance completed");
        return true;
    }
    
    // Motorcycle-specific method
    public void ride(double distance) {
        if (!isRunning) {
            System.out.println("Motorcycle: Cannot ride - engine not running");
            return;
        }
        
        double fuelNeeded = distance / getFuelEfficiency();
        if (fuelLevel >= fuelNeeded) {
            consumeFuel(fuelNeeded);
            updateMileage(distance);
            System.out.println("Motorcycle: Rode " + distance + " miles");
        } else {
            System.out.println("Motorcycle: Not enough fuel to ride " + distance + " miles");
        }
    }
    
    public String getEngineType() {
        return engineType;
    }
    
    public boolean hasSidecar() {
        return hasSidecar;
    }
    
    public int getEngineDisplacement() {
        return engineDisplacement;
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Engine Type: " + engineType);
        System.out.println("Sidecar: " + hasSidecar);
        System.out.println("Engine Displacement: " + engineDisplacement + "cc");
    }
} 