## Problem: 
BlockingQueue Interface Methods Demonstration II

## Description: 
Create a program that demonstrates the various methods of the BlockingQueue Interface in Java, including add, offer, put, take, poll, peek, and size.

## Input: 
None

## Output:
```
Initial BlockingQueue: []
BlockingQueue after adding 10: [10]
BlockingQueue after adding 20: [10, 20]
BlockingQueue after adding 30: [10, 20, 30]
Added element 40: true
BlockingQueue after adding: [10, 20, 30, 40]
Offered element 50: true
BlockingQueue after offering: [10, 20, 30, 40, 50]
Pooled element: 10
BlockingQueue after polling: [20, 30, 40, 50]
Peeked element: 20
BlockingQueue size: 4
BlockingQueue is empty: false
Took element: 20
BlockingQueue after taking: [30, 40, 50]
Removed element using remove: 30
BlockingQueue after removing: [40, 50]
Removed element using remove: 40
BlockingQueue after removing: [50]
Removed element using remove: 50
BlockingQueue after removing: []
BlockingQueue is empty: true
```

## Code Answer:
```Java
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueDemo2 {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();

        System.out.println("Initial BlockingQueue: " + blockingQueue);

        // Add elements
        blockingQueue.add(10);
        System.out.println("BlockingQueue after adding 10: " + blockingQueue);
        blockingQueue.add(20);
        System.out.println("BlockingQueue after adding 20: " + blockingQueue);
        blockingQueue.add(30);
        System.out.println("BlockingQueue after adding 30: " + blockingQueue);

        // Add element
        System.out.println("Added element 40: " + blockingQueue.add(40));
        System.out.println("BlockingQueue after adding: " + blockingQueue);

        // Offer element
        System.out.println("Offered element 50: " + blockingQueue.offer(50));
        System.out.println("BlockingQueue after offering: " + blockingQueue);

        // Poll element
        System.out.println("Pooled element: " + blockingQueue.poll());
        System.out.println("BlockingQueue after polling: " + blockingQueue);

        // Peek element
        System.out.println("Peeked element: " + blockingQueue.peek());

        // Get blockingQueue size
        System.out.println("BlockingQueue size: " + blockingQueue.size());

        // Check if blockingQueue is empty
        System.out.println("BlockingQueue is empty: " + blockingQueue.isEmpty());

        // Take element
        System.out.println("Took element: " + blockingQueue.take());
        System.out.println("BlockingQueue after taking: " + blockingQueue);

        // Remove element using remove
        System.out.println("Removed element using remove: " + blockingQueue.remove());
        System.out.println("BlockingQueue after removing: " + blockingQueue);

        // Remove element using remove
        System.out.println("Removed element using remove: " + blockingQueue.remove());
        System.out.println("BlockingQueue after removing: " + blockingQueue);

        // Remove element using remove
        System.out.println("Removed element using remove: " + blockingQueue.remove());
        System.out.println("BlockingQueue after removing: " + blockingQueue);

        // Check if blockingQueue is empty
        System.out.println("BlockingQueue is empty: " + blockingQueue.isEmpty());
    }
}
```

File Name: BlockingQueueDemo2.java

You can copy and paste this code into a Java file named BlockingQueueDemo2.java and run it to see the output.
Practical Use Case:

A BlockingQueue is a useful data structure in situations where elements need to be processed in a specific order, and the processing thread needs to wait for elements to be available, such as:
* Producer-Consumer problem: A BlockingQueue can be used to solve the producer-consumer problem, where producers add elements to the queue and consumers remove elements from the queue.
* Thread synchronization: BlockingQueues can be used to synchronize threads in a multithreaded environment.
Job scheduling: A BlockingQueue can be used to schedule jobs in a printer or a CPU.
* Resource allocation: A BlockingQueue can be used to allocate resources such as memory or I/O devices.

In this program, we demonstrate the various methods of the BlockingQueue Interface, including adding elements, offering elements, putting elements, taking elements, polling elements, peeking elements, and getting the size of the queue. This program can be