## Problem: 
PriorityBlockingQueue Methods Demonstration II

## Description: 
Create a program that demonstrates the various methods of the PriorityBlockingQueue class in Java, including put, take, offer, poll, peek, and size.

## Input: 
None

## Output:
```
Initial PriorityBlockingQueue: []
PriorityBlockingQueue after putting 10: [10]
PriorityBlockingQueue after putting 20: [10, 20]
PriorityBlockingQueue after putting 30: [10, 20, 30]
Took element: 10
PriorityBlockingQueue after taking: [20, 30]
Peeked element: 20
PriorityBlockingQueue size: 2
PriorityBlockingQueue is empty: false
Offered element 40: true
PriorityBlockingQueue after offering: [20, 30, 40]
Polled element: 20
PriorityBlockingQueue after polling: [30, 40]
PriorityBlockingQueue is empty: false
Removed element using remove: 30
PriorityBlockingQueue after removing: [40]
Removed element using remove: 40
PriorityBlockingQueue after removing: []
PriorityBlockingQueue is empty: true
```

## Code Answer:
```Java
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueueDemo2 {
    public static void main(String[] args) throws InterruptedException {
        PriorityBlockingQueue<Integer> priorityBlockingQueue = new PriorityBlockingQueue<>();

        System.out.println("Initial PriorityBlockingQueue: " + priorityBlockingQueue);

        // Put elements
        priorityBlockingQueue.put(10);
        System.out.println("PriorityBlockingQueue after putting 10: " + priorityBlockingQueue);
        priorityBlockingQueue.put(20);
        System.out.println("PriorityBlockingQueue after putting 20: " + priorityBlockingQueue);
        priorityBlockingQueue.put(30);
        System.out.println("PriorityBlockingQueue after putting 30: " + priorityBlockingQueue);

        // Take element
        System.out.println("Took element: " + priorityBlockingQueue.take());
        System.out.println("PriorityBlockingQueue after taking: " + priorityBlockingQueue);

        // Peek element
        System.out.println("Peeked element: " + priorityBlockingQueue.peek());

        // Get priorityBlockingQueue size
        System.out.println("PriorityBlockingQueue size: " + priorityBlockingQueue.size());

        // Check if priorityBlockingQueue is empty
        System.out.println("PriorityBlockingQueue is empty: " + priorityBlockingQueue.isEmpty());

        // Offer element
        System.out.println("Offered element 40: " + priorityBlockingQueue.offer(40));
        System.out.println("PriorityBlockingQueue after offering: " + priorityBlockingQueue);

        // Poll element
        System.out.println("Polled element: " + priorityBlockingQueue.poll());
        System.out.println("PriorityBlockingQueue after polling: " + priorityBlockingQueue);

        // Check if priorityBlockingQueue is empty
        System.out.println("PriorityBlockingQueue is empty: " + priorityBlockingQueue.isEmpty());

        // Remove element using remove
        System.out.println("Removed element using remove: " + priorityBlockingQueue.remove());
        System.out.println("PriorityBlockingQueue after removing: " + priorityBlockingQueue);

        // Remove element using remove
        System.out.println("Removed element using remove: " + priorityBlockingQueue.remove());
        System.out.println("PriorityBlockingQueue after removing: " + priorityBlockingQueue);

        // Check if priorityBlockingQueue is empty
        System.out.println("PriorityBlockingQueue is empty: " + priorityBlockingQueue.isEmpty());
    }
}
```

File Name: PriorityBlockingQueueDemo2.java

You can copy and paste this code into a Java file named PriorityBlockingQueueDemo2.java and run it to see the output.

## Practical Use Case:

A PriorityBlockingQueue is a useful data structure in situations where elements need to be processed in a specific order based on their priority, and the processing thread needs to wait for elements to be available, such as:
* Job scheduling: A PriorityBlockingQueue can be used to schedule jobs based on their priority.
* Resource allocation: A PriorityBlockingQueue can be used to allocate resources such as memory or I/O devices based on their priority.
* Event handling: A PriorityBlockingQueue can be used to handle events based on their priority.

In this program, we demonstrate the various methods of the PriorityBlockingQueue class, including putting elements, taking elements, offering elements, polling elements, peeking elements, and getting the size of the queue. This program can be used as a starting point for understanding the PriorityBlockingQueue class and its methods.