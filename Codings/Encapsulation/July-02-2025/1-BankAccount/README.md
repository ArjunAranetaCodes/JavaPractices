# Bank Account Management - Encapsulation Tutorial

## Overview
This program demonstrates basic encapsulation principles using a Bank Account class. Encapsulation is one of the four fundamental principles of Object-Oriented Programming (OOP) that bundles data and methods that operate on that data within a single unit (class) and restricts access to some of the object's components.

## What is Encapsulation?
Encapsulation is the bundling of data and the methods that operate on that data within a single unit or object, while hiding the internal state and requiring all interactions to be performed through an object's methods.

## Key Concepts Demonstrated

### 1. Private Fields (Data Hiding)
- `accountNumber` - Private field that cannot be accessed directly from outside the class
- `accountHolderName` - Private field for account holder information
- `balance` - Private field that stores the current balance
- `pin` - Private field for security

### 2. Public Methods (Interface)
- `getAccountNumber()` - Public getter method to access account number
- `getAccountHolderName()` - Public getter method to access account holder name
- `getBalance()` - Public getter method to access balance
- `deposit()` - Public method to add money to account
- `withdraw()` - Public method to remove money from account
- `changePin()` - Public method to change PIN

### 3. Constructor
- Initializes account with required information
- Validates initial deposit amount

## Benefits of Encapsulation

1. **Data Hiding**: Private fields prevent direct access and modification
2. **Controlled Access**: Public methods provide controlled access to private data
3. **Validation**: Methods can include validation logic before modifying data
4. **Maintenance**: Changes to internal implementation don't affect external code
5. **Security**: Sensitive data (like PIN) is protected from unauthorized access

## Code Structure

```java
public class BankAccount {
    // Private fields (data hiding)
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private String pin;
    
    // Constructor
    public BankAccount(String accountNumber, String accountHolderName, double initialDeposit, String pin)
    
    // Public getter methods
    public String getAccountNumber()
    public String getAccountHolderName()
    public double getBalance()
    
    // Public setter methods with validation
    public void deposit(double amount)
    public boolean withdraw(double amount, String pin)
    public boolean changePin(String oldPin, String newPin)
}
```

## How to Run
1. Compile: `javac BankAccount.java`
2. Run: `java BankAccount`

## Expected Output
The program will demonstrate:
- Creating bank accounts
- Depositing and withdrawing money
- PIN validation
- Balance checking
- Error handling for invalid operations

## Learning Objectives
- Understand how to implement encapsulation in Java
- Learn the difference between private and public access modifiers
- See how getter and setter methods work
- Understand data validation in encapsulated classes
- Learn best practices for secure data handling 