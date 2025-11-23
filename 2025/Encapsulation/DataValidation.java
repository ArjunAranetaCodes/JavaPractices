/**
 * Tutorial: Data Validation in Encapsulation
 * Demonstrates validation in setter methods
 */
public class DataValidation {
    private String accountNumber;
    private double balance;
    private String password;
    
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public void setAccountNumber(String accountNumber) {
        if (accountNumber != null && accountNumber.matches("\\d{10}")) {
            this.accountNumber = accountNumber;
        } else {
            System.out.println("Account number must be 10 digits");
        }
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("Balance cannot be negative");
        }
    }
    
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }
    
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            this.balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds");
        }
    }
    
    public void setPassword(String password) {
        if (password != null && password.length() >= 8) {
            this.password = password;
            System.out.println("Password set successfully");
        } else {
            System.out.println("Password must be at least 8 characters");
        }
    }
    
    public static void main(String[] args) {
        DataValidation account = new DataValidation();
        
        account.setAccountNumber("1234567890");
        account.setBalance(1000.0);
        account.deposit(500.0);
        account.withdraw(200.0);
        System.out.println("Balance: $" + account.getBalance());
        
        // Invalid operations
        account.setAccountNumber("123");  // Invalid
        account.withdraw(2000.0);  // Insufficient funds
        account.setPassword("short");  // Too short
    }
}
















