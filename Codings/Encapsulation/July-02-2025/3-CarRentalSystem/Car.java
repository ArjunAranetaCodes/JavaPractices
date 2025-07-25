import java.util.Arrays;

/**
 * Car Rental System - Encapsulation with Business Logic
 * Demonstrates encapsulation with complex business logic and state management
 */
public class Car {
    // Private fields - Data hiding with state management
    private String carId;
    private String model;
    private int year;
    private double dailyRate;
    private boolean isAvailable;
    private String currentRenter;
    private String rentalStartDate;
    private double totalEarnings;
    private MaintenanceRecord[] maintenanceHistory;
    private int maintenanceCount;
    private boolean isUnderMaintenance;
    
    // Constructor
    public Car(String carId, String model, int year, double dailyRate) {
        this.carId = carId;
        this.model = model;
        this.year = year;
        this.dailyRate = dailyRate;
        this.isAvailable = true;
        this.currentRenter = null;
        this.rentalStartDate = null;
        this.totalEarnings = 0.0;
        this.maintenanceHistory = new MaintenanceRecord[10];
        this.maintenanceCount = 0;
        this.isUnderMaintenance = false;
    }
    
    // Public business logic methods
    public boolean rentCar(String customerName, String startDate, int days) {
        // Validate rental request
        if (customerName == null || customerName.trim().isEmpty()) {
            System.out.println("Error: Customer name cannot be null or empty.");
            return false;
        }
        
        if (!isValidRentalDuration(days)) {
            System.out.println("Error: Rental duration must be positive.");
            return false;
        }
        
        if (!isAvailable) {
            System.out.println("Error: Car is not available for rental.");
            return false;
        }
        
        if (isUnderMaintenance) {
            System.out.println("Error: Car is currently under maintenance.");
            return false;
        }
        
        // Process rental
        this.currentRenter = customerName;
        this.rentalStartDate = startDate;
        this.isAvailable = false;
        
        System.out.println("Car rented successfully to " + customerName + " for " + days + " days starting " + startDate);
        return true;
    }
    
    public double returnCar(String customerName) {
        // Validate return request
        if (customerName == null || customerName.trim().isEmpty()) {
            System.out.println("Error: Customer name cannot be null or empty.");
            return 0.0;
        }
        
        if (isAvailable) {
            System.out.println("Error: Car is not currently rented.");
            return 0.0;
        }
        
        if (!customerName.equals(currentRenter)) {
            System.out.println("Error: Car is not rented to " + customerName);
            return 0.0;
        }
        
        // Calculate rental cost (simplified - assuming 1 day rental for demo)
        double rentalCost = calculateRentalCost(1);
        totalEarnings += rentalCost;
        
        // Reset rental state
        this.currentRenter = null;
        this.rentalStartDate = null;
        this.isAvailable = true;
        
        System.out.println("Car returned successfully by " + customerName);
        System.out.println("Rental cost: $" + rentalCost);
        return rentalCost;
    }
    
    public boolean scheduleMaintenance(String reason, String scheduledDate) {
        // Validate maintenance request
        if (reason == null || reason.trim().isEmpty()) {
            System.out.println("Error: Maintenance reason cannot be null or empty.");
            return false;
        }
        
        if (scheduledDate == null || scheduledDate.trim().isEmpty()) {
            System.out.println("Error: Scheduled date cannot be null or empty.");
            return false;
        }
        
        if (!isAvailable) {
            System.out.println("Error: Cannot schedule maintenance while car is rented.");
            return false;
        }
        
        if (isUnderMaintenance) {
            System.out.println("Error: Car is already under maintenance.");
            return false;
        }
        
        // Schedule maintenance
        isUnderMaintenance = true;
        isAvailable = false;
        addMaintenanceRecord(reason, scheduledDate, false);
        
        System.out.println("Maintenance scheduled for " + scheduledDate + " - Reason: " + reason);
        return true;
    }
    
    public boolean completeMaintenance() {
        if (!isUnderMaintenance) {
            System.out.println("Error: Car is not currently under maintenance.");
            return false;
        }
        
        // Complete maintenance
        isUnderMaintenance = false;
        isAvailable = true;
        
        // Mark the latest maintenance record as completed
        if (maintenanceCount > 0) {
            maintenanceHistory[maintenanceCount - 1].setCompleted(true);
        }
        
        System.out.println("Maintenance completed successfully. Car is now available for rental.");
        return true;
    }
    
    public boolean isUnderMaintenance() {
        return isUnderMaintenance;
    }
    
    // Public getter methods - Controlled access to private data
    public String getCarId() {
        return carId;
    }
    
    public String getModel() {
        return model;
    }
    
    public int getYear() {
        return year;
    }
    
    public double getDailyRate() {
        return dailyRate;
    }
    
    public boolean isAvailable() {
        return isAvailable;
    }
    
    public String getCurrentRenter() {
        return currentRenter;
    }
    
    public double getTotalEarnings() {
        return totalEarnings;
    }
    
    public MaintenanceRecord[] getMaintenanceHistory() {
        // Return a copy to prevent external modification
        return Arrays.copyOf(maintenanceHistory, maintenanceCount);
    }
    
    // Private helper methods
    private double calculateRentalCost(int days) {
        return dailyRate * days;
    }
    
    private boolean isValidRentalDuration(int days) {
        return days > 0;
    }
    
    private void addMaintenanceRecord(String reason, String date, boolean completed) {
        // Expand array if needed
        if (maintenanceCount >= maintenanceHistory.length) {
            maintenanceHistory = Arrays.copyOf(maintenanceHistory, maintenanceHistory.length * 2);
        }
        
        maintenanceHistory[maintenanceCount++] = new MaintenanceRecord(reason, date, completed);
    }
    
    private boolean isCurrentlyRented() {
        return !isAvailable && !isUnderMaintenance;
    }
    
    // Method to display car information
    public void displayCarInfo() {
        System.out.println("\n=== Car Information ===");
        System.out.println("Car ID: " + carId);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Daily Rate: $" + dailyRate);
        System.out.println("Available: " + isAvailable);
        System.out.println("Under Maintenance: " + isUnderMaintenance);
        
        if (isCurrentlyRented()) {
            System.out.println("Current Renter: " + currentRenter);
            System.out.println("Rental Start Date: " + rentalStartDate);
        }
        
        System.out.println("Total Earnings: $" + totalEarnings);
        System.out.println("Maintenance Records: " + maintenanceCount);
        
        if (maintenanceCount > 0) {
            System.out.println("Recent Maintenance:");
            for (int i = Math.max(0, maintenanceCount - 3); i < maintenanceCount; i++) {
                MaintenanceRecord record = maintenanceHistory[i];
                System.out.println("  - " + record.getDate() + ": " + record.getReason() + 
                                 " (" + (record.isCompleted() ? "Completed" : "Scheduled") + ")");
            }
        }
        System.out.println("===========================");
    }
    
    // Main method to demonstrate encapsulation with business logic
    public static void main(String[] args) {
        System.out.println("=== Car Rental System - Encapsulation with Business Logic ===\n");
        
        // Create a car
        Car car = new Car("CAR001", "Toyota Camry", 2022, 50.0);
        car.displayCarInfo();
        
        // Demonstrate rental operations
        System.out.println("\n--- Rental Operations ---");
        car.rentCar("John Smith", "2024-07-01", 3);
        car.rentCar("Jane Doe", "2024-07-05", 2); // Should fail - car already rented
        
        // Demonstrate return operations
        System.out.println("\n--- Return Operations ---");
        car.returnCar("John Smith");
        car.returnCar("Jane Doe"); // Should fail - not rented to Jane
        
        // Demonstrate maintenance operations
        System.out.println("\n--- Maintenance Operations ---");
        car.scheduleMaintenance("Oil change and inspection", "2024-07-10");
        car.rentCar("Bob Johnson", "2024-07-15", 5); // Should fail - under maintenance
        car.completeMaintenance();
        
        // Demonstrate successful rental after maintenance
        System.out.println("\n--- Post-Maintenance Rental ---");
        car.rentCar("Alice Brown", "2024-07-20", 4);
        car.returnCar("Alice Brown");
        
        // Schedule another maintenance
        car.scheduleMaintenance("Tire rotation", "2024-07-25");
        car.completeMaintenance();
        
        // Final display
        car.displayCarInfo();
        
        System.out.println("\n=== Business Logic Benefits Demonstrated ===");
        System.out.println("1. State consistency: Car cannot be in invalid states");
        System.out.println("2. Business rules: All operations follow rental business logic");
        System.out.println("3. Financial tracking: Earnings are automatically calculated");
        System.out.println("4. Audit trail: Maintenance history is maintained");
        System.out.println("5. Error prevention: Invalid operations are prevented");
    }
}

/**
 * Maintenance Record class to track maintenance history
 */
class MaintenanceRecord {
    private String reason;
    private String date;
    private boolean completed;
    
    public MaintenanceRecord(String reason, String date, boolean completed) {
        this.reason = reason;
        this.date = date;
        this.completed = completed;
    }
    
    public String getReason() {
        return reason;
    }
    
    public String getDate() {
        return date;
    }
    
    public boolean isCompleted() {
        return completed;
    }
    
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
} 