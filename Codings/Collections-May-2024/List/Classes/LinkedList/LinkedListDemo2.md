## Problem: 
LinkedList Class Methods Demonstration II

## Description: 
Create a program that demonstrates the various methods of the LinkedList class in Java, including addFirst, addLast, getFirst, getLast, removeFirst, and removeLast.

## Input: 
None

## Output:
```
Initial LinkedList: []
LinkedList after adding 10 at beginning: [10]
LinkedList after adding 20 at end: [10, 20]
LinkedList after adding 30 at beginning: [30, 10, 20]
First element: 30
Last element: 20
LinkedList after removing first element: [10, 20]
LinkedList after removing last element: [10]
```

## Code Answer:

```java
import java.util.LinkedList;

public class LinkedListDemo2 {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        System.out.println("Initial LinkedList: " + linkedList);

        // Add element at beginning
        linkedList.addFirst(10);
        System.out.println("LinkedList after adding 10 at beginning: " + linkedList);

        // Add element at end
        linkedList.addLast(20);
        System.out.println("LinkedList after adding 20 at end: " + linkedList);

        // Add element at beginning
        linkedList.addFirst(30);
        System.out.println("LinkedList after adding 30 at beginning: " + linkedList);

        // Get first element
        System.out.println("First element: " + linkedList.getFirst());

        // Get last element
        System.out.println("Last element: " + linkedList.getLast());

        // Remove first element
        linkedList.removeFirst();
        System.out.println("LinkedList after removing first element: " + linkedList);

        // Remove last element
        linkedList.removeLast();
        System.out.println("LinkedList after removing last element: " + linkedList);
    }
}
```

**File Name:** `LinkedListDemo2.java`

This program creates a LinkedList, adds elements at the beginning and end, gets the first and last elements, removes the first and last elements, and demonstrates the result of each operation.