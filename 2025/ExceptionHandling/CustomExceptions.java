/**
 * Tutorial: Custom Exceptions
 * Demonstrates creating custom exception classes
 */
// Custom checked exception
class InsufficientFundsException extends Exception {
    private double amount;
    
    public InsufficientFundsException(double amount) {
        super("Insufficient funds. Required: $" + amount);
        this.amount = amount;
    }
    
    public double getAmount() {
        return amount;
    }
}

// Custom unchecked exception
class InvalidAgeException extends RuntimeException {
    public InvalidAgeException(String message) {
        super(message);
    }
}

class BankAccount {
    private double balance;
    
    public BankAccount(double balance) {
        this.balance = balance;
    }
    
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException(amount);
        }
        balance -= amount;
        System.out.println("Withdrawn: $" + amount);
    }
    
    public void setAge(int age) {
        if (age < 0 || age > 150) {
            throw new InvalidAgeException("Age must be between 0 and 150");
        }
        System.out.println("Age set to: " + age);
    }
}

public class CustomExceptions {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(100.0);
        
        try {
            account.withdraw(50.0);
            account.withdraw(100.0);  // Will throw exception
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        try {
            account.setAge(25);
            account.setAge(200);  // Will throw exception
        } catch (InvalidAgeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}


















