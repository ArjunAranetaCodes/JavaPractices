abstract class Account {
    String accountNumber;
    double balance;

    abstract void deposit(double amount);

    void displayBalance() {
        System.out.println("Balance: $" + balance);
    }
}

class SavingsAccount extends Account {
    double interestRate;

    SavingsAccount(String accountNumber, double interestRate) {
        this.accountNumber = accountNumber;
        this.interestRate = interestRate;
    }

    void deposit(double amount) {
        balance += amount + (amount * interestRate);
    }
}

class AbstractAccountTest {
    public static void main(String[] args) {
        SavingsAccount savingsAccount = new SavingsAccount("S12345", 0.05);
        savingsAccount.deposit(1000);
        savingsAccount.displayBalance();
    }
}
