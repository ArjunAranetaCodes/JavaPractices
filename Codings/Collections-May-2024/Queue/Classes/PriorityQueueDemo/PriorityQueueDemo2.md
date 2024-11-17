## Problem: 
PriorityQueue Methods Demonstration II

## Description: 
Create a program that demonstrates the various methods of the PriorityQueue class in Java, including add, offer, remove, poll, peek, and size.

## Input: 
None

## Output:
```
Initial PriorityQueue: []
PriorityQueue after adding 30: [30]
PriorityQueue after adding 20: [20, 30]
PriorityQueue after adding 10: [10, 20, 30]
Removed element: 10
PriorityQueue after removing: [20, 30]
Peeked element: 20
PriorityQueue size: 2
PriorityQueue is empty: false
Polling element: 20
PriorityQueue after polling: [30]
PriorityQueue is empty: false
Removed element using remove: 30
PriorityQueue after removing: []
PriorityQueue is empty: true
```

## Code Answer:
```Java
import java.util.PriorityQueue;

public class PriorityQueueDemo2 {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        System.out.println("Initial PriorityQueue: " + priorityQueue);

        // Add elements
        priorityQueue.add(30);
        System.out.println("PriorityQueue after adding 30: " + priorityQueue);
        priorityQueue.add(20);
        System.out.println("PriorityQueue after adding 20: " + priorityQueue);
        priorityQueue.add(10);
        System.out.println("PriorityQueue after adding 10: " + priorityQueue);

        // Remove element
        System.out.println("Removed element: " + priorityQueue.remove());
        System.out.println("PriorityQueue after removing: " + priorityQueue);

        // Peek element
        System.out.println("Peeked element: " + priorityQueue.peek());

        // Get priorityQueue size
        System.out.println("PriorityQueue size: " + priorityQueue.size());

        // Check if priorityQueue is empty
        System.out.println("PriorityQueue is empty: " + priorityQueue.isEmpty());

        // Poll element
        System.out.println("Polling element: " + priorityQueue.poll());
        System.out.println("PriorityQueue after polling: " + priorityQueue);

        // Check if priorityQueue is empty
        System.out.println("PriorityQueue is empty: " + priorityQueue.isEmpty());

        // Remove element using remove
        System.out.println("Removed element using remove: " + priorityQueue.remove());
        System.out.println("PriorityQueue after removing: " + priorityQueue);

        // Check if priorityQueue is empty
        System.out.println("PriorityQueue is empty: " + priorityQueue.isEmpty());
    }
}
```
File Name: PriorityQueueDemo2.java

You can copy and paste this code into a Java file named PriorityQueueDemo2.java and run it to see the output.

## Practical Use Case:

A PriorityQueue is a useful data structure in situations where elements need to be processed in a specific order based on their priority, such as:
* Job scheduling: A PriorityQueue can be used to schedule jobs based on their priority.
* Resource allocation: A PriorityQueue can be used to allocate resources such as memory or I/O devices based on their priority.
* Event handling: A PriorityQueue can be used to handle events based on their priority.

In this program, we demonstrate the various methods of the PriorityQueue class, including adding elements, removing elements, peeking elements, polling elements, and getting the size of the queue. This program can be used as a starting point for understanding the PriorityQueue class and its methods.