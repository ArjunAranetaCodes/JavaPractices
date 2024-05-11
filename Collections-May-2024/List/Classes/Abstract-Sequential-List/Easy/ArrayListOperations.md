# Problem: 
ArrayList Operations

## Description: 
Implement a Java program using the Abstract Sequential List Class (ArrayList) to perform basic operations such as adding, removing, and searching for elements.

## Input:
A list of integers: [1, 2, 3, 4, 5]
An element to add: 6
An element to remove: 4
An element to search: 3

## Output:
The updated list after adding and removing elements: [1, 2, 3, 5, 6]
The index of the searched element: 2

## Code Answer:
```
import java.util.ArrayList;

public class ArrayListOperations {
    public static void main(String[] args) {
        // Create an ArrayList
        ArrayList<Integer> list = new ArrayList<>();

        // Add elements
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        // Add a new element
        list.add(6);

        // Remove an element
        list.remove((Integer) 4);

        // Search for an element
        int index = list.indexOf(3);

        // Print the updated list and the index of the searched element
        System.out.println("Updated List: " + list);
        System.out.println("Index of 3: " + index);
    }
}
```

## Explanation:
* We create an ArrayList of integers and add elements to it.
* We add a new element using the add() method.
* We remove an element using the remove() method.
* We search for an element using the indexOf() method.
* We print the updated list and the index of the searched element.

<p>Note: This code uses the ArrayList class from the Java Collections Framework, which is a built-in library in Java. The Abstract Sequential List Class is an abstract class that ArrayList extends, providing the basic implementation for a sequential list.</p>