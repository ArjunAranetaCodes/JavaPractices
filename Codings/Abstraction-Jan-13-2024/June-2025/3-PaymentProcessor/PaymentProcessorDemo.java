package PaymentProcessor;

public class PaymentProcessorDemo {
    public static void main(String[] args) {
        System.out.println("=== Payment Processor Demo ===\n");
        
        // Creating different payment methods
        PaymentMethod creditCard = new CreditCard("1234567890123456", "John Doe", 500.0, 
                                                 "USD", "Visa", "12/25", 5000);
        PaymentMethod bankAccount = new BankAccount("987654321", "Jane Smith", 2500.0, 
                                                   "USD", "Chase Bank", "Savings", 500.0);
        PaymentMethod digitalWallet = new DigitalWallet("WALLET001", "Bob Johnson", 300.0, 
                                                       "USD", "PayPal", "555-123-4567", true);
        
        // Display account information
        System.out.println("=== Account Information ===");
        creditCard.displayAccountInfo();
        bankAccount.displayAccountInfo();
        digitalWallet.displayAccountInfo();
        
        // Process payments
        System.out.println("=== Processing Payments ===");
        double paymentAmount = 100.0;
        
        System.out.println("Processing payment of " + paymentAmount + " USD:");
        creditCard.processPayment(paymentAmount);
        bankAccount.processPayment(paymentAmount);
        digitalWallet.processPayment(paymentAmount);
        
        // Process refunds
        System.out.println("\n=== Processing Refunds ===");
        double refundAmount = 50.0;
        
        System.out.println("Processing refund of " + refundAmount + " USD:");
        creditCard.processRefund(refundAmount);
        bankAccount.processRefund(refundAmount);
        digitalWallet.processRefund(refundAmount);
        
        // Demonstrating polymorphic behavior
        System.out.println("\n=== Polymorphic Payment Processing ===");
        PaymentMethod[] paymentMethods = {creditCard, bankAccount, digitalWallet};
        
        for (PaymentMethod method : paymentMethods) {
            System.out.println("Payment Method: " + method.getPaymentDetails());
            System.out.println("Account Valid: " + method.validateAccount());
            System.out.println("Current Balance: " + method.getCurrency() + " " + method.getBalance());
            System.out.println("------------------------");
        }
        
        // Demonstrating specific behaviors
        System.out.println("=== Specific Behaviors ===");
        ((DigitalWallet) digitalWallet).sendMoney("555-987-6543", 25.0);
        System.out.println("Credit Card Available Credit: " + ((CreditCard) creditCard).getAvailableCredit());
        System.out.println("Bank Account Overdraft Protection: " + ((BankAccount) bankAccount).hasOverdraftProtection());
    }
} 