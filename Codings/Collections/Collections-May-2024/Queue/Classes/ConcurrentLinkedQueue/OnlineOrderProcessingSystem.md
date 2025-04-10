## Problem: 
Online Order Processing System

## Description: 
Create a program that demonstrates the methods of the ConcurrentLinkedQueue class in a real-world implementation of an online order processing system. The program should allow multiple customers to add and remove orders from a queue concurrently.

## Input:
Customer 1: Add Order 1
Customer 2: Add Order 2
Customer 3: Remove Order 1
Customer 4: Add Order 3
## Output:
Order 1 added by Customer 1
Order 2 added by Customer 2
Order 1 removed by Customer 3
Order 3 added by Customer 4
## Code Answer:
```Java
import java.util.concurrent.ConcurrentLinkedQueue;

public class OnlineOrderProcessingSystem {
    private ConcurrentLinkedQueue<String> orderQueue = new ConcurrentLinkedQueue<>();

    public void addOrder(String order, String customer) {
        orderQueue.add(order);
        System.out.println(order + " added by " + customer);
    }

    public void removeOrder(String order, String customer) {
        if (orderQueue.remove(order)) {
            System.out.println(order + " removed by " + customer);
        } else {
            System.out.println(order + " not found");
        }
    }

    public static void main(String[] args) {
        OnlineOrderProcessingSystem onlineOrderProcessingSystem = new OnlineOrderProcessingSystem();

        // Customer 1
        onlineOrderProcessingSystem.addOrder("Order 1", "Customer 1");

        // Customer 2
        onlineOrderProcessingSystem.addOrder("Order 2", "Customer 2");

        // Customer 3
        onlineOrderProcessingSystem.removeOrder("Order 1", "Customer 3");

        // Customer 4
        onlineOrderProcessingSystem.addOrder("Order 3", "Customer 4");
    }
}
```

File Name: OnlineOrderProcessingSystem.java

Definition of the Class: ConcurrentLinkedQueue is a thread-safe implementation of a queue that allows multiple threads to add and remove elements concurrently without the need for external synchronization.

This program demonstrates the methods of the ConcurrentLinkedQueue class in a real-world implementation of an online order processing system. Multiple customers can add and remove orders from the queue concurrently without worrying about thread safety issues. The output shows the orders being added and removed by different customers.