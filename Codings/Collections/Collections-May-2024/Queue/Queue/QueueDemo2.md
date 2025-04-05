## Problem: 
Queue Interface Methods Demonstration II

## Description: 
Create a program that demonstrates the various methods of the Queue Interface in Java, including offer, poll, peek, and size.

## Input: 
None

## Output:
```
Initial Queue: []
Queue after offering 10: [10]
Queue after offering 20: [10, 20]
Queue after offering 30: [10, 20, 30]
Polled element: 10
Queue after poll: [20, 30]
Peeked element: 20
Queue size: 2
Queue is empty: false
Queue after clearing: []
Queue is empty: true
```

## Code Answer:

```java
import java.util.Queue;
import java.util.LinkedList;

public class QueueDemo2 {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        System.out.println("Initial Queue: " + queue);

        // Offer elements
        queue.offer(10);
        System.out.println("Queue after offering 10: " + queue);
        queue.offer(20);
        System.out.println("Queue after offering 20: " + queue);
        queue.offer(30);
        System.out.println("Queue after offering 30: " + queue);

        // Poll element
        System.out.println("Polled element: " + queue.poll());
        System.out.println("Queue after poll: " + queue);

        // Peek element
        System.out.println("Peeked element: " + queue.peek());

        // Get queue size
        System.out.println("Queue size: " + queue.size());

        // Check if queue is empty
        System.out.println("Queue is empty: " + queue.isEmpty());

        // Clear queue
        queue.clear();
        System.out.println("Queue after clearing: " + queue);

        // Check if queue is empty
        System.out.println("Queue is empty: " + queue.isEmpty());
    }
}
```

**File Name:** `QueueDemo2.java`

This program creates a Queue, offers elements, polls an element, peeks the element at the head of the queue, gets the size of the queue, checks if the queue is empty, and clears the queue. The output demonstrates the result of each operation.

## Practical Use Case:
A queue is a useful data structure in situations where elements need to be processed in a specific order, such as:
* Job scheduling: A queue can be used to schedule jobs in a printer or a CPU.
* Resource allocation: A queue can be used to allocate resources such as memory or I/O devices.
* Network protocols: Queues are used in network protocols such as TCP/IP to manage packet transmission.
* Thread synchronization: Queues can be used to synchronize threads in a multithreaded environment.

In this program, we demonstrate the various methods of the Queue class, including adding elements, removing elements, getting the size of the queue, and checking if the queue is empty. This program can be used as a starting point for understanding the Queue class and its methods.