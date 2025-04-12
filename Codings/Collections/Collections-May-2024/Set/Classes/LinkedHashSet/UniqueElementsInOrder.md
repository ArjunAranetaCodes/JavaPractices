## Problem: 
Maintaining the Order of Unique Elements

## Description: 
Create a program that demonstrates the use of LinkedHashSet to maintain the order of unique elements.

## Input:

Elements: ["Apple", "Banana", "Apple", "Orange", "Banana", "Grape"]

## Output:

Unique elements in order: ["Apple", "Banana", "Orange", "Grape"]

## Code Answer:
```Java
import java.util.*;

public class UniqueElementsInOrder {
    public static void main(String[] args) {
        List<String> elements = Arrays.asList(
        "Apple",
        "Banana",
        "Apple",
        "Orange",
        "Banana",
        "Grape"
    );

        Set<String> uniqueElements = new LinkedHashSet<>(elements);

        System.out.println("Unique elements in order: " + uniqueElements);
    }
}
```

File Name: UniqueElementsInOrder.java

This program demonstrates the use of LinkedHashSet to maintain the order of unique elements. The main method creates a list of elements, some of which are duplicates, and then uses a LinkedHashSet to collect the unique elements in the order they were first encountered.
Note: LinkedHashSet is a collection that stores unique elements in the order they were first encountered, and it uses a hash table for storage. It is useful for storing a collection of unique elements and maintaining their order.