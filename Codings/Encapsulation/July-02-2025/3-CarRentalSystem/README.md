# Car Rental System - Encapsulation with Business Logic

## Overview
This program demonstrates encapsulation with complex business logic and state management. It shows how to encapsulate car rental operations while maintaining data integrity and enforcing business rules.

## What is Business Logic in Encapsulation?
Business logic refers to the rules and operations that govern how data can be manipulated within an encapsulated class. It ensures that all operations follow the domain-specific rules and maintain the object's integrity.

## Key Concepts Demonstrated

### 1. Private Fields with State Management
- `carId` - Unique identifier for the car
- `model` - Car model name
- `year` - Manufacturing year
- `dailyRate` - Cost per day for rental
- `isAvailable` - Current availability status
- `currentRenter` - Currently renting customer (null if available)
- `rentalStartDate` - When current rental started
- `totalEarnings` - Total earnings from this car
- `maintenanceHistory` - Array of maintenance records

### 2. Business Logic Methods
- `rentCar()` - Rents the car to a customer with validation
- `returnCar()` - Returns the car and calculates charges
- `calculateRentalCost()` - Calculates cost based on rental duration
- `scheduleMaintenance()` - Schedules maintenance for the car
- `completeMaintenance()` - Marks maintenance as completed
- `isUnderMaintenance()` - Checks if car is currently under maintenance
- `getMaintenanceHistory()` - Returns maintenance records

### 3. State Validation
- Car cannot be rented if already rented
- Car cannot be rented if under maintenance
- Car cannot be returned if not currently rented
- Maintenance cannot be scheduled if car is currently rented
- Rental duration must be positive

## Benefits of Business Logic in Encapsulation

1. **Data Consistency**: Business rules ensure data remains consistent
2. **State Management**: Complex state transitions are handled safely
3. **Business Rules**: Domain-specific logic is centralized
4. **Error Prevention**: Invalid operations are prevented
5. **Audit Trail**: Important operations are logged and tracked

## Code Structure

```java
public class Car {
    // Private fields with state management
    private String carId;
    private String model;
    private int year;
    private double dailyRate;
    private boolean isAvailable;
    private String currentRenter;
    private String rentalStartDate;
    private double totalEarnings;
    private MaintenanceRecord[] maintenanceHistory;
    
    // Constructor
    public Car(String carId, String model, int year, double dailyRate)
    
    // Public business logic methods
    public boolean rentCar(String customerName, String startDate, int days)
    public double returnCar(String customerName)
    public boolean scheduleMaintenance(String reason, String scheduledDate)
    public boolean completeMaintenance()
    public boolean isUnderMaintenance()
    
    // Public getter methods
    public String getCarId()
    public String getModel()
    public int getYear()
    public double getDailyRate()
    public boolean isAvailable()
    public String getCurrentRenter()
    public double getTotalEarnings()
    public MaintenanceRecord[] getMaintenanceHistory()
    
    // Private helper methods
    private double calculateRentalCost(int days)
    private boolean isValidRentalDuration(int days)
    private void addMaintenanceRecord(String reason, String date, boolean completed)
    private boolean isCurrentlyRented()
}
```

## Business Rules Implemented

1. **Rental Rules**:
   - Car must be available and not under maintenance
   - Rental duration must be positive
   - Customer name cannot be null or empty

2. **Return Rules**:
   - Car must be currently rented to the specified customer
   - Charges are calculated based on actual rental duration

3. **Maintenance Rules**:
   - Car cannot be under maintenance if currently rented
   - Maintenance records are tracked with timestamps
   - Maintenance completion updates car availability

4. **Financial Tracking**:
   - Total earnings are automatically updated
   - Rental costs are calculated using daily rate

## How to Run
1. Compile: `javac Car.java`
2. Run: `java Car`

## Expected Output
The program will demonstrate:
- Car rental and return operations
- Maintenance scheduling and completion
- Financial tracking and reporting
- State validation and error handling
- Business rule enforcement

## Learning Objectives
- Understand how to implement complex business logic in encapsulated classes
- Learn state management techniques
- See how to enforce business rules through encapsulation
- Understand audit trail and logging concepts
- Learn best practices for domain-specific validation 