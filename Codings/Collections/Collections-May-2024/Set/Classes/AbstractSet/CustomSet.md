## Problem: 
Implementing a Simple Custom Set

## Description: 
Create a program that demonstrates the use of AbstractSet to implement a custom set.

## Input:
Add: "Apple"

Add: "Banana"

Add: "Apple"

Add: "Orange"

## Output:
["Apple", "Banana", "Orange"]

## Code Answer:
```Java
import java.util.*;

public class CustomSet extends AbstractSet<String> {
private List<String> elements = new ArrayList<>();

    public boolean add(String element) {
        if (!elements.contains(element)) {
            elements.add(element);
            return true;
        }
        return false;
    }

    public boolean contains(Object object) {
        return elements.contains(object);
    }

    public Iterator<String> iterator() {
        return elements.iterator();
    }

    public int size() {
        return elements.size();
    }

    public static void main(String[] args) {
        CustomSet set = new CustomSet();
        set.add("Apple");
        set.add("Banana");
        set.add("Apple");
        set.add("Orange");

        System.out.println(set);
    }
}
```

File Name: CustomSet.java

This program demonstrates the use of AbstractSet to implement a custom set. The CustomSet class extends AbstractSet and provides implementations for the add, contains, iterator, and size methods. The main method creates a CustomSet instance, adds elements to it, and prints the set.