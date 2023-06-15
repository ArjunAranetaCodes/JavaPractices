interface PaymentGateway {
    void processPayment(double amount);
    void refundPayment(double amount);
}

class CreditCardPayment implements PaymentGateway {
    @Override
    public void processPayment(double amount) {
        // Implement credit card payment processing logic
        System.out.println("Credit card payment processed for amount: $" + amount);
    }

    @Override
    public void refundPayment(double amount) {
        // Implement credit card payment refund logic
        System.out.println("Credit card payment refunded for amount: $" + amount);
    }
}

class PayPalPayment implements PaymentGateway {
    @Override
    public void processPayment(double amount) {
        // Implement PayPal payment processing logic
        System.out.println("PayPal payment processed for amount: $" + amount);
    }

    @Override
    public void refundPayment(double amount) {
        // Implement PayPal payment refund logic
        System.out.println("PayPal payment refunded for amount: $" + amount);
    }
}

class BitcoinPayment implements PaymentGateway {
    @Override
    public void processPayment(double amount) {
        // Implement Bitcoin payment processing logic
        System.out.println("Bitcoin payment processed for amount: $" + amount);
    }

    @Override
    public void refundPayment(double amount) {
        // Implement Bitcoin payment refund logic
        System.out.println("Bitcoin payment refunded for amount: $" + amount);
    }
}

public class PaymentDemo {
    public static void main(String[] args) {
        CreditCardPayment creditCardPayment = new CreditCardPayment();
        creditCardPayment.processPayment(100.0);
        creditCardPayment.refundPayment(20.0);

        PayPalPayment payPalPayment = new PayPalPayment();
        payPalPayment.processPayment(150.0);
        payPalPayment.refundPayment(30.0);

        BitcoinPayment bitcoinPayment = new BitcoinPayment();
        bitcoinPayment.processPayment(200.0);
        bitcoinPayment.refundPayment(40.0);
    }
}
