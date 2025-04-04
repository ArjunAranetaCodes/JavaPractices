import java.util.concurrent.LinkedTransferQueue;

public class BankingTransactions {
    private LinkedTransferQueue<String> transactionQueue = new LinkedTransferQueue<>();

    public void addTransaction(String transaction) {
        transactionQueue.add(transaction);
        System.out.println("Transaction added: " + transaction);
    }

    public void processTransactions() {
        while (true) {
            try{
                String transaction = transactionQueue.take();
                System.out.println("Processing transaction: " + transaction);
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }
            // Process the transaction
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