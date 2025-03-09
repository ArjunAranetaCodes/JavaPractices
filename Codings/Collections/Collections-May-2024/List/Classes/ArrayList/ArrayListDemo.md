# Problem
ArrayList Class Methods Demonstration

## Description: 
Create a program that demonstrates the various methods of the ArrayList class in Java, including add, remove, get, set, size, and clear.

## Input: 
None

# Output:
```
Initial ArrayList: [10, 20, 30, 40, 50]
ArrayList after adding 60: [10, 20, 30, 40, 50, 60]
Removed element: 30
ArrayList after removing 30: [10, 20, 40, 50, 60]
Element at index 2: 40
ArrayList after replacing 40 with 70: [10, 20, 70, 50, 60]
ArrayList size: 5
ArrayList after clearing: []
```

# Code Answer:

```
import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        // Add elements
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        arrayList.add(40);
        arrayList.add(50);

        System.out.println("Initial ArrayList: " + arrayList);

        // Add element at the end
        arrayList.add(60);
        System.out.println("ArrayList after adding 60: " + arrayList);

        // Remove element
        arrayList.remove(2);
        System.out.println("Removed element: " + 30);
        System.out.println("ArrayList after removing 30: " + arrayList);

        // Get element at index
        System.out.println("Element at index 2: " + arrayList.get(2));

        // Replace element at index
        arrayList.set(2, 70);
        System.out.println("ArrayList after replacing 40 with 70: " + arrayList);

        // Get size of ArrayList
        System.out.println("ArrayList size: " + arrayList.size());

        // Clear ArrayList
        arrayList.clear();
        System.out.println("ArrayList after clearing: " + arrayList);
    }
}
```

This program creates an ArrayList, adds elements, removes an element, gets an element at a specific index, replaces an element, gets the size of the ArrayList, and finally clears the ArrayList. The output demonstrates the result of each operation.