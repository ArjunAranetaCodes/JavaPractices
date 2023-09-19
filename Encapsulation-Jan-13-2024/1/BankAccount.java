public class BankAccount {
    private double balance;
    private String accountNumber;

    public BankAccount(String accNumber, double initialBalance) {
        accountNumber = accNumber;
        balance = initialBalance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
