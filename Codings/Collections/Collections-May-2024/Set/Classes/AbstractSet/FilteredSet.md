## Problem: 
Implementing a Simple Filtered Set

## Description: 
Create a program that demonstrates the use of AbstractSet to implement a filtered set.

## Input:

Add: "Apple"

Add: "Banana"

Add: "Cherry"

Filter: "A"

## Output:
["Apple"]

## Code Answer:
```Java
import java.util.*;

public class FilteredSet extends AbstractSet<String> {
private Set<String> originalSet;
private String filter;

    public FilteredSet(Set<String> originalSet, String filter) {
        this.originalSet = originalSet;
        this.filter = filter;
    }

    public Iterator<String> iterator() {
        return new FilteredIterator(originalSet.iterator(), filter);
    }

    public int size() {
        int count = 0;
        for (String element : originalSet) {
            if (element.startsWith(filter)) {
                count++;
            }
        }
        return count;
    }

    public boolean contains(Object object) {
        return originalSet.contains(object) && object.toString().startsWith(filter);
    }

    public static void main(String[] args) {
        Set<String> originalSet = new HashSet<>();
        originalSet.add("Apple");
        originalSet.add("Banana");
        originalSet.add("Cherry");

        FilteredSet filteredSet = new FilteredSet(originalSet, "A");

        System.out.println(filteredSet);
    }
}

class FilteredIterator implements Iterator<String> {
private Iterator<String> originalIterator;
private String filter;

    public FilteredIterator(Iterator<String> originalIterator, String filter) {
        this.originalIterator = originalIterator;
        this.filter = filter;
    }

    public boolean hasNext() {
        while (originalIterator.hasNext()) {
            String element = originalIterator.next();
            if (element.startsWith(filter)) {
                return true;
            }
        }
        return false;
    }

    public String next() {
        return originalIterator.next();
    }
}
```

File Name: FilteredSet.java

This program demonstrates the use of AbstractSet to implement a filtered set. The FilteredSet class extends AbstractSet and provides implementations for the iterator, size, and contains methods. The main method creates a FilteredSet instance with a filter string "A" and prints the filtered set.