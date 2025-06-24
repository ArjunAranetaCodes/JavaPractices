package VehicleManagement;

// Abstract class representing a vehicle
public abstract class Vehicle {
    protected String make;
    protected String model;
    protected int year;
    protected String color;
    protected double fuelLevel;
    protected double maxFuelCapacity;
    protected boolean isRunning;
    protected double mileage;
    
    // Constructor
    public Vehicle(String make, String model, int year, String color, 
                   double maxFuelCapacity) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.maxFuelCapacity = maxFuelCapacity;
        this.fuelLevel = maxFuelCapacity;
        this.isRunning = false;
        this.mileage = 0.0;
    }
    
    // Abstract method - each vehicle must implement its own start logic
    public abstract boolean start();
    
    // Abstract method for stopping
    public abstract boolean stop();
    
    // Abstract method for refueling
    public abstract boolean refuel(double amount);
    
    // Abstract method for getting vehicle type
    public abstract String getVehicleType();
    
    // Abstract method for getting fuel efficiency
    public abstract double getFuelEfficiency();
    
    // Abstract method for maintenance check
    public abstract boolean performMaintenance();
    
    // Concrete method - shared behavior
    public void displayInfo() {
        System.out.println("Vehicle: " + make + " " + model + " (" + year + ")");
        System.out.println("Color: " + color);
        System.out.println("Type: " + getVehicleType());
        System.out.println("Fuel Level: " + fuelLevel + "/" + maxFuelCapacity + " gallons");
        System.out.println("Mileage: " + mileage + " miles");
        System.out.println("Running: " + isRunning);
        System.out.println("Fuel Efficiency: " + getFuelEfficiency() + " mpg");
        System.out.println("------------------------");
    }
    
    // Concrete method to check fuel level
    public boolean hasFuel() {
        return fuelLevel > 0;
    }
    
    // Concrete method to update mileage
    protected void updateMileage(double distance) {
        this.mileage += distance;
    }
    
    // Concrete method to consume fuel
    protected void consumeFuel(double amount) {
        if (fuelLevel >= amount) {
            fuelLevel -= amount;
        } else {
            fuelLevel = 0;
        }
    }
    
    // Concrete method to add fuel
    protected void addFuel(double amount) {
        double spaceAvailable = maxFuelCapacity - fuelLevel;
        if (amount <= spaceAvailable) {
            fuelLevel += amount;
        } else {
            fuelLevel = maxFuelCapacity;
        }
    }
    
    // Getter methods
    public String getMake() {
        return make;
    }
    
    public String getModel() {
        return model;
    }
    
    public int getYear() {
        return year;
    }
    
    public String getColor() {
        return color;
    }
    
    public double getFuelLevel() {
        return fuelLevel;
    }
    
    public double getMaxFuelCapacity() {
        return maxFuelCapacity;
    }
    
    public boolean isRunning() {
        return isRunning;
    }
    
    public double getMileage() {
        return mileage;
    }
    
    // Setter methods
    public void setColor(String color) {
        this.color = color;
    }
    
    protected void setRunning(boolean running) {
        this.isRunning = running;
    }
} 