/**
 * Bank Account Management - Encapsulation Example
 * Demonstrates basic encapsulation principles with private fields and public methods
 */
public class BankAccount {
    // Private fields - Data hiding
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private String pin;
    
    // Constructor
    public BankAccount(String accountNumber, String accountHolderName, double initialDeposit, String pin) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.pin = pin;
        
        // Validation in constructor
        if (initialDeposit >= 0) {
            this.balance = initialDeposit;
        } else {
            throw new IllegalArgumentException("Initial deposit cannot be negative");
        }
    }
    
    // Public getter methods - Controlled access to private data
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public String getAccountHolderName() {
        return accountHolderName;
    }
    
    public double getBalance() {
        return balance;
    }
    
    // Public methods with validation
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
            System.out.println("New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount. Amount must be positive.");
        }
    }
    
    public boolean withdraw(double amount, String providedPin) {
        if (!pin.equals(providedPin)) {
            System.out.println("Invalid PIN. Withdrawal denied.");
            return false;
        }
        
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
            System.out.println("New balance: $" + balance);
            return true;
        } else if (amount > balance) {
            System.out.println("Insufficient funds. Current balance: $" + balance);
            return false;
        } else {
            System.out.println("Invalid withdrawal amount. Amount must be positive.");
            return false;
        }
    }
    
    public boolean changePin(String oldPin, String newPin) {
        if (pin.equals(oldPin)) {
            if (newPin != null && newPin.length() >= 4) {
                pin = newPin;
                System.out.println("PIN changed successfully.");
                return true;
            } else {
                System.out.println("New PIN must be at least 4 characters long.");
                return false;
            }
        } else {
            System.out.println("Invalid old PIN. PIN change denied.");
            return false;
        }
    }
    
    // Method to display account information
    public void displayAccountInfo() {
        System.out.println("\n=== Account Information ===");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Current Balance: $" + balance);
        System.out.println("===========================");
    }
    
    // Main method to demonstrate encapsulation
    public static void main(String[] args) {
        System.out.println("=== Bank Account Encapsulation Demo ===\n");
        
        try {
            // Create a bank account
            BankAccount account = new BankAccount("1234567890", "John Doe", 1000.0, "1234");
            
            // Display initial account information
            account.displayAccountInfo();
            
            // Demonstrate deposit functionality
            System.out.println("\n--- Deposit Operations ---");
            account.deposit(500.0);
            account.deposit(-100.0); // Invalid deposit
            
            // Demonstrate withdrawal functionality
            System.out.println("\n--- Withdrawal Operations ---");
            account.withdraw(200.0, "1234"); // Valid withdrawal
            account.withdraw(2000.0, "1234"); // Insufficient funds
            account.withdraw(100.0, "9999"); // Invalid PIN
            
            // Demonstrate PIN change
            System.out.println("\n--- PIN Change Operations ---");
            account.changePin("1234", "5678"); // Valid PIN change
            account.changePin("1234", "5678"); // Invalid old PIN
            account.changePin("5678", "123"); // Invalid new PIN (too short)
            
            // Final account information
            account.displayAccountInfo();
            
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating account: " + e.getMessage());
        }
        
        System.out.println("\n=== Encapsulation Benefits Demonstrated ===");
        System.out.println("1. Data hiding: Private fields cannot be accessed directly");
        System.out.println("2. Controlled access: All operations go through public methods");
        System.out.println("3. Validation: Methods validate input before modifying data");
        System.out.println("4. Security: PIN is protected from unauthorized access");
        System.out.println("5. Maintenance: Internal changes don't affect external code");
    }
} 