package PaymentProcessor;

public class BankAccount extends PaymentMethod {
    private String bankName;
    private String accountType;
    private double overdraftLimit;
    
    public BankAccount(String accountNumber, String accountHolder, double balance, 
                      String currency, String bankName, String accountType, double overdraftLimit) {
        super(accountNumber, accountHolder, balance, currency);
        this.bankName = bankName;
        this.accountType = accountType;
        this.overdraftLimit = overdraftLimit;
    }
    
    @Override
    public boolean processPayment(double amount) {
        if (validateAccount() && hasSufficientBalance(amount)) {
            updateBalance(-amount);
            System.out.println("Bank account payment processed: " + currency + " " + amount);
            return true;
        } else {
            System.out.println("Bank account payment failed: Insufficient funds or invalid account");
            return false;
        }
    }
    
    @Override
    public boolean processRefund(double amount) {
        if (validateAccount()) {
            updateBalance(amount);
            System.out.println("Bank account refund processed: " + currency + " " + amount);
            return true;
        } else {
            System.out.println("Bank account refund failed: Invalid account");
            return false;
        }
    }
    
    @Override
    public boolean validateAccount() {
        // Check if account number is valid and bank name is provided
        return accountNumber.length() >= 8 && !bankName.isEmpty();
    }
    
    @Override
    public String getPaymentDetails() {
        return "Bank Account - " + bankName + " - " + accountType;
    }
    
    // Bank account specific method
    public boolean hasOverdraftProtection() {
        return overdraftLimit > 0;
    }
    
    public String getBankName() {
        return bankName;
    }
    
    public String getAccountType() {
        return accountType;
    }
    
    public double getOverdraftLimit() {
        return overdraftLimit;
    }
    
    @Override
    public void displayAccountInfo() {
        super.displayAccountInfo();
        System.out.println("Bank Name: " + bankName);
        System.out.println("Account Type: " + accountType);
        System.out.println("Overdraft Limit: " + currency + " " + overdraftLimit);
    }
} 