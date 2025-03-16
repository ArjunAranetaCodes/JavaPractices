## Problem: 
Implementing a Cache

## Description: 
Create a program that demonstrates the use of Map to implement a cache.

## Input:

Key-value pairs: {"key1", "value1"}, {"key2", "value2"}, {"key3", "value3"}

## Output:

Cached values:

key1 = value1

key2 = value2

key3 = value3

## Code Answer:
```Java
import java.util.Map;
import java.util.HashMap;

public class Cache {
private Map<String, String> cache;

    public Cache() {
        this.cache = new HashMap<>();
    }

    public void put(String key, String value) {
        cache.put(key, value);
    }

    public String get(String key) {
        return cache.get(key);
    }

    public static void main(String[] args) {
        Cache cache = new Cache();

        cache.put("key1", "value1");
        cache.put("key2", "value2");
        cache.put("key3", "value3");

        System.out.println("Cached values:");
        for (Map.Entry<String, String> entry : cache.cache.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
```

File Name: Cache.java

This program demonstrates the use of Map to implement a cache. The Cache class uses a HashMap to store key-value pairs. The put method adds a key-value pair to the cache, and the get method retrieves a value by its key. The program prints the cached values.

Note: Map is a collection that stores key-value pairs, and it provides methods for navigating and searching the elements in the map. It is useful for implementing caches, dictionaries, and other similar data structures.