import java.util.concurrent.LinkedBlockingDeque;

public class BankingTransactions {
    private LinkedBlockingDeque<String> transactionDeque = new LinkedBlockingDeque<>();

    public void addTransaction(String transaction) {
        try {
            transactionDeque.put(transaction);
            System.out.println("Transaction added: " + transaction);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void processTransactions() {
        while (true) {
            try {
                String transaction = transactionDeque.take();
                System.out.println("Processing transaction: " + transaction);
                // Process the transaction
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        BankingTransactions bankingTransactions = new BankingTransactions();

        Thread teller1 = new Thread(() -> {
            bankingTransactions.addTransaction("Deposit $100");
        });

        Thread teller2 = new Thread(() -> {
            bankingTransactions.addTransaction("Withdraw $50");
        });

        Thread teller3 = new Thread(() -> {
            bankingTransactions.addTransaction("Deposit $200");
        });

        Thread teller4 = new Thread(() -> {
            bankingTransactions.addTransaction("Withdraw $75");
        });

        teller1.start();
        teller2.start();
        teller3.start();
        teller4.start();

        bankingTransactions.processTransactions();
    }
}