## Problem: 
Thread-Safe Queue for Banking Transactions

## Description: 
Create a program that demonstrates the use of LinkedBlockingQueue as a thread-safe queue for banking transactions. The program should have multiple threads that represent bank tellers, and each teller should be able to add transactions to the queue.

## Input:
Teller 1: Deposit $100
Teller 2: Withdraw $50
Teller 3: Deposit $200
Teller 4: Withdraw $75
## Output:
Transaction added: Deposit $100
Transaction added: Withdraw $50
Transaction added: Deposit $200
Transaction added: Withdraw $75

## Code Answer:
```Java
import java.util.concurrent.LinkedBlockingQueue;

public class BankingTransactions {
private LinkedBlockingQueue<String> transactionQueue = new LinkedBlockingQueue<>();

    public void addTransaction(String transaction) {
        try {
            transactionQueue.put(transaction);
            System.out.println("Transaction added: " + transaction);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void processTransactions() {
        while (true) {
            try {
                String transaction = transactionQueue.take();
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
```

File Name: BankingTransactions.java

This program demonstrates the use of LinkedBlockingQueue as a thread-safe queue for banking transactions. Multiple threads representing bank tellers add transactions to the queue, and a separate thread processes the transactions from the queue. The output shows the transactions being added and processed by the respective threads.