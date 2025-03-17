## Problem: 
Implementing a Cache with Order of Insertion

## Description: 
Create a program that demonstrates the use of LinkedHashMap to implement a cache that preserves the order of insertion.

## Input:

Cache entries: {"Key1", "Value1"}, {"Key2", "Value2"}, {"Key3", "Value3"}, {"Key4", "Value4"}

## Output:

Cache entries in order of insertion:

Key1 = Value1

Key2 = Value2

Key3 = Value3

Key4 = Value4

## Code Answer:
```Java
import java.util.LinkedHashMap;
import java.util.Map;

public class InsertionOrderCache {
    private LinkedHashMap<String, String> cache;

    public InsertionOrderCache() {
        cache = new LinkedHashMap<>();
    }

    public void put(String key, String value) {
        cache.put(key, value);
    }

    public String get(String key) {
        return cache.get(key);
    }

    public static void main(String[] args) {
        InsertionOrderCache cache = new InsertionOrderCache();

        cache.put("Key1", "Value1");
        cache.put("Key2", "Value2");
        cache.put("Key3", "Value3");
        cache.put("Key4", "Value4");

        System.out.println("Cache entries in order of insertion:");
        for (Map.Entry<String, String> entry : cache.cache.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
```

File Name: InsertionOrderCache.java

This program demonstrates the use of LinkedHashMap to implement a cache that preserves the order of insertion. The InsertionOrderCache class uses a LinkedHashMap to store cache entries, and provides methods for adding and retrieving values. The main() method tests the cache by adding entries and printing the cache entries in the order of insertion.

Note: LinkedHashMap is used to implement a cache that preserves the order of insertion. This is useful for creating caches, dictionaries, and other similar data structures that need to preserve the order of insertion.