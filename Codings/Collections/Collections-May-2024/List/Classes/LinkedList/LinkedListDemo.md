## Problem: 

LinkedList Class Methods Demonstration

## Description: 
Create a program that demonstrates the various methods of the LinkedList class in Java, including add, remove, get, set, size, and clear.

## Input: 
None

## Output:
```
Initial LinkedList: []
LinkedList after adding 10: [10]
LinkedList after adding 20: [10, 20]
LinkedList after adding 30: [10, 20, 30]
Removed element: 20
LinkedList after removing 20: [10, 30]
Element at index 0: 10
LinkedList after replacing 10 with 40: [40, 30]
LinkedList size: 2
LinkedList after clearing: []
```

## Code Answer:

```java
import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        System.out.println("Initial LinkedList: " + linkedList);

        // Add elements
        linkedList.add(10);
        System.out.println("LinkedList after adding 10: " + linkedList);
        linkedList.add(20);
        System.out.println("LinkedList after adding 20: " + linkedList);
        linkedList.add(30);
        System.out.println("LinkedList after adding 30: " + linkedList);

        // Remove element
        linkedList.remove(1);
        System.out.println("Removed element: " + 20);
        System.out.println("LinkedList after removing 20: " + linkedList);

        // Get element at index
        System.out.println("Element at index 0: " + linkedList.get(0));

        // Replace element at index
        linkedList.set(0, 40);
        System.out.println("LinkedList after replacing 10 with 40: " + linkedList);

        // Get size of LinkedList
        System.out.println("LinkedList size: " + linkedList.size());

        // Clear LinkedList
        linkedList.clear();
        System.out.println("LinkedList after clearing: " + linkedList);
    }
}
```

**File Name:** `LinkedListDemo.java`

This program creates a LinkedList, adds elements, removes an element, gets an element at a specific index, replaces an element, gets the size of the LinkedList, and finally clears the LinkedList. The output demonstrates the result of each operation.