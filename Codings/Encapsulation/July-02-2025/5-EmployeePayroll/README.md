# Employee Payroll System - Advanced Encapsulation with Calculations

## Overview
This program demonstrates advanced encapsulation using an Employee class and a PayrollSystem class. It shows how to encapsulate employee data, perform payroll calculations, and provide controlled access to sensitive information.

## Key Concepts Demonstrated

### 1. Private Fields in Employee
- `employeeId` - Unique identifier
- `name` - Employee name
- `baseSalary` - Base monthly salary
- `bonus` - Monthly bonus
- `taxRate` - Tax rate (percentage)
- `netSalary` - Calculated net salary

### 2. PayrollSystem Class
- `employees` - Array of Employee objects
- `employeeCount` - Number of employees

### 3. Public Methods for Payroll Management
- `addEmployee()` - Adds a new employee
- `removeEmployee()` - Removes an employee by ID
- `calculateNetSalary()` - Calculates net salary after tax and bonus
- `getEmployeeById()` - Finds an employee by ID
- `listAllEmployees()` - Lists all employees with payroll info

## Benefits of Advanced Encapsulation

1. **Sensitive Data Protection**: Salary and tax info is private
2. **Controlled Access**: Only allowed payroll operations are exposed
3. **Validation**: Prevents invalid salary/tax values
4. **Calculation Logic**: Centralized and easy to update

## Code Structure

```java
class Employee {
    private int employeeId;
    private String name;
    private double baseSalary;
    private double bonus;
    private double taxRate;
    // Constructor, getters, setters, and calculation methods
}

class PayrollSystem {
    private Employee[] employees;
    private int employeeCount;
    // Methods to add, remove, calculate, and list employees
}
```

## How to Run
1. Compile: `javac PayrollSystem.java`
2. Run: `java PayrollSystem`

## Expected Output
The program will demonstrate:
- Adding and removing employees
- Calculating net salary
- Listing all employees with payroll info
- Error handling for invalid operations

## Learning Objectives
- Understand advanced encapsulation with calculations
- Learn how to protect sensitive payroll data
- See how to implement payroll logic in an encapsulated way 