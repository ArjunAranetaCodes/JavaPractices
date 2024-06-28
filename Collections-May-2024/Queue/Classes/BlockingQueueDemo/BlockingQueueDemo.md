## Problem: 
BlockingQueue Interface Methods Demonstration

## Description: 
Create a program that demonstrates the various methods of the BlockingQueue Interface in Java, including put, take, offer, poll, peek, and size.

## Input: 
None

## Output:
```
Initial BlockingQueue: []
BlockingQueue after putting 10: [10]
BlockingQueue after putting 20: [10, 20]
BlockingQueue after putting 30: [10, 20, 30]
Took element: 10
BlockingQueue after taking: [20, 30]
Peeked element: 20
BlockingQueue size: 2
BlockingQueue is empty: false
Offered element 40: true
BlockingQueue after offering: [20, 30, 40]
Pooled element: 20
BlockingQueue after polling: [30, 40]
BlockingQueue is empty: false
Removed element using remove: 30
BlockingQueue after removing: [40]
BlockingQueue is empty: false
Removed element using remove: 40
BlockingQueue after removing: []
BlockingQueue is empty: true
```

## Code Answer:
```Java
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();

        System.out.println("Initial BlockingQueue: " + blockingQueue);

        // Put elements
        blockingQueue.put(10);
        System.out.println("BlockingQueue after putting 10: " + blockingQueue);
        blockingQueue.put(20);
        System.out.println("BlockingQueue after putting 20: " + blockingQueue);
        blockingQueue.put(30);
        System.out.println("BlockingQueue after putting 30: " + blockingQueue);

        // Take element
        System.out.println("Took element: " + blockingQueue.take());
        System.out.println("BlockingQueue after taking: " + blockingQueue);

        // Peek element
        System.out.println("Peeked element: " + blockingQueue.peek());

        // Get blockingQueue size
        System.out.println("BlockingQueue size: " + blockingQueue.size());

        // Check if blockingQueue is empty
        System.out.println("BlockingQueue is empty: " + blockingQueue.isEmpty());

        // Offer element
        System.out.println("Offered element 40: " + blockingQueue.offer(40));
        System.out.println("BlockingQueue after offering: " + blockingQueue);

        // Poll element
        System.out.println("Pooled element: " + blockingQueue.poll());
        System.out.println("BlockingQueue after polling: " + blockingQueue);

        // Check if blockingQueue is empty
        System.out.println("BlockingQueue is empty: " + blockingQueue.isEmpty());

        // Remove element using remove
        System.out.println("Removed element using remove: " + blockingQueue.remove());
        System.out.println("BlockingQueue after removing: " + blockingQueue);

        // Check if blockingQueue is empty
        System.out.println("BlockingQueue is empty: " + blockingQueue.isEmpty());

        // Remove element using remove
        System.out.println("Removed element using remove: " + blockingQueue.remove());
        System.out.println("BlockingQueue after removing: " + blockingQueue);

        // Check if blockingQueue is empty
        System.out.println("BlockingQueue is empty: " + blockingQueue.isEmpty());
    }
}
```

File Name: BlockingQueueDemo.java

You can copy and paste this code into a Java file named BlockingQueueDemo.java and run it to see the output.
Practical Use Case:

* A BlockingQueue is a useful data structure in situations where elements need to be processed in a specific order, and the processing thread needs to wait for elements to be available, such as:

* Producer-Consumer problem: A BlockingQueue can be used to solve the producer-consumer problem, where producers add elements to the queue and consumers remove elements from the queue.

* Thread synchronization: BlockingQueues can be used to synchronize threads in a multithreaded environment.
Job scheduling: A BlockingQueue can be used to schedule jobs in a printer or a CPU.

* Resource allocation: A BlockingQueue can be used to allocate resources such as memory or I/O devices.

In this program, we demonstrate the various methods of the BlockingQueue Interface, including putting elements, taking elements, offering elements, polling elements, peeking elements, and getting the size of the queue. This program can be used as a starting point for understanding the BlockingQueue Interface and its methods.