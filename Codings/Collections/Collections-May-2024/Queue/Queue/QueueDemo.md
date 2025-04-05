## Problem: 
Queue Interface Methods Demonstration

## Description: 
Create a program that demonstrates the various methods of the Queue Interface in Java, including add, offer, remove, poll, element, and peek.

## Input: 
None

## Output:
```
Initial Queue: []
Queue after adding 10: [10]
Queue after adding 20: [10, 20]
Queue after adding 30: [10, 20, 30]
Removed element: 10
Queue after removing: [20, 30]
Element: 20
Peeked element: 20
Queue is empty: false
Removed element using poll: 20
Queue after poll: [30]
Queue is empty: false
Removed element using remove: 30
Queue after remove: []
Queue is empty: true
```

## Code Answer:

```java
import java.util.Queue;
import java.util.LinkedList;

public class QueueDemo {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        System.out.println("Initial Queue: " + queue);

        // Add elements
        queue.add(10);
        System.out.println("Queue after adding 10: " + queue);
        queue.add(20);
        System.out.println("Queue after adding 20: " + queue);
        queue.add(30);
        System.out.println("Queue after adding 30: " + queue);

        // Remove element
        System.out.println("Removed element: " + queue.remove());
        System.out.println("Queue after removing: " + queue);

        // Get element
        System.out.println("Element: " + queue.element());

        // Peek element
        System.out.println("Peeked element: " + queue.peek());

        // Check if queue is empty
        System.out.println("Queue is empty: " + queue.isEmpty());

        // Remove element using poll
        System.out.println("Removed element using poll: " + queue.poll());
        System.out.println("Queue after poll: " + queue);

        // Check if queue is empty
        System.out.println("Queue is empty: " + queue.isEmpty());

        // Remove element using remove
        System.out.println("Removed element using remove: " + queue.remove());
        System.out.println("Queue after remove: " + queue);

        // Check if queue is empty
        System.out.println("Queue is empty: " + queue.isEmpty());
    }
}
```
**File Name:** `QueueDemo.java`

This program creates a Queue, adds elements, removes elements using remove and poll methods, gets the element at the head of the queue, peeks the element at the head of the queue, and checks if the queue is empty. The output demonstrates the result of each operation.

## Practical Use Case:
A queue is a useful data structure in situations where elements need to be processed in a specific order, such as:
* Job scheduling: A queue can be used to schedule jobs in a printer or a CPU.
* Resource allocation: A queue can be used to allocate resources such as memory or I/O devices.
* Network protocols: Queues are used in network protocols such as TCP/IP to manage packet transmission.
* Thread synchronization: Queues can be used to synchronize threads in a multithreaded environment.

In this program, we demonstrate the various methods of the Queue class, including adding elements, removing elements, getting the size of the queue, and checking if the queue is empty. This program can be used as a starting point for understanding the Queue class and its methods.