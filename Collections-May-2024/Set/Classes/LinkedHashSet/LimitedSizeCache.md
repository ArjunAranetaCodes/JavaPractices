## Problem: 
Implementing a Cache with Limited Size

## Description: 
Create a program that demonstrates the use of LinkedHashSet to implement a cache with a limited size.

## Input:

Cache size: 3

Elements: ["A", "B", "C", "D", "E", "F"]

## Output:

Cache contents: ["D", "E", "F"]

## Code Answer:

```Java
import java.util.*;

public class LimitedSizeCache {
    private final int maxSize;
    private final LinkedHashSet<String> cache;

    public LimitedSizeCache(int maxSize) {
        this.maxSize = maxSize;
        this.cache = new LinkedHashSet<>();
    }

    public void add(String element) {
        if (cache.size() >= maxSize) {
            // Remove the oldest element (first added)
            cache.remove(cache.iterator().next());
        }
        cache.add(element);
    }

    public Set<String> getCache() {
        return cache;
    }

    public static void main(String[] args) {
        LimitedSizeCache cache = new LimitedSizeCache(3);

        cache.add("A");
        cache.add("B");
        cache.add("C");
        cache.add("D");
        cache.add("E");
        cache.add("F");

        System.out.println("Cache contents: " + cache.getCache());
    }
}
```

File Name: LimitedSizeCache.java

This program demonstrates the use of LinkedHashSet to implement a cache with a limited size. The LimitedSizeCache class uses a LinkedHashSet to store elements in the order they were added, and it removes the oldest element (first added) when the cache reaches its maximum size.
Note: LinkedHashSet is a collection that stores unique elements in the order they were first encountered, and it uses a hash table for storage. It is useful for storing a collection of unique elements and maintaining their order, making it suitable for implementing a cache with a limited size.