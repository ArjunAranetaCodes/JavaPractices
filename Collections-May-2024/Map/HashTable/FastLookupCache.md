## Problem: 
Implementing a Cache with Fast Lookup

## Description: 
Create a program that demonstrates the use of Hashtable to implement a cache with fast lookup, which stores frequently accessed data to improve performance.

## Input:

Cache entries: {"Key1", "Value1"}, {"Key2", "Value2"}, {"Key3", "Value3"}

## Output:

Cache entries:

Key1 = Value1

Key2 = Value2

Key3 = Value3

## Code Answer:
```Java
import java.util.Hashtable;

public class FastLookupCache {
    private Hashtable<String, String> cache;

    public FastLookupCache() {
        cache = new Hashtable<>();
    }

    public void put(String key, String value) {
        cache.put(key, value);
    }

    public String get(String key) {
        return cache.get(key);
    }

    public static void main(String[] args) {
        FastLookupCache cache = new FastLookupCache();

        cache.put("Key1", "Value1");
        cache.put("Key2", "Value2");
        cache.put("Key3", "Value3");

        System.out.println("Cache entries:");
        for (String key : cache.cache.keySet()) {
            System.out.println(key + " = " + cache.get(key));
        }
    }
}
```

File Name: FastLookupCache.java

This program demonstrates the use of Hashtable to implement a cache with fast lookup, which stores frequently accessed data to improve performance. The FastLookupCache class uses a Hashtable to store cache entries, and provides methods for adding and retrieving values. The main() method tests the cache by adding entries and printing the cache entries.

Note: Hashtable is used to implement a cache with fast lookup, which stores frequently accessed data to improve performance. This is useful for creating caches, dictionaries, and other similar data structures that need to store information with fast lookup.