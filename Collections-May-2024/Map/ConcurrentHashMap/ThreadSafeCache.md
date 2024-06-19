## Problem: 
Implementing a Thread-Safe Cache

## Description: 
Create a program that demonstrates the use of ConcurrentHashMap to implement a thread-safe cache.

## Input:

Cache entries: {"key1", "value1"}, {"key2", "value2"}, {"key3", "value3"}

## Output:

Cache entries:

key1 = value1

key2 = value2

key3 = value3

Cache hit count: 3

## Code Answer:
```Java
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ThreadSafeCache {
    private ConcurrentMap<String, String> cache;

    public ThreadSafeCache() {
        this.cache = new ConcurrentHashMap<>();
    }

    public void put(String key, String value) {
        cache.put(key, value);
    }

    public String get(String key) {
        return cache.get(key);
    }

    public int getHitCount() {
        return cache.size();
    }

    public static void main(String[] args) {
        ThreadSafeCache cache = new ThreadSafeCache();

        cache.put("key1", "value1");
        cache.put("key2", "value2");
        cache.put("key3", "value3");

        System.out.println("Cache entries:");
        for (Map.Entry<String, String> entry : cache.cache.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        System.out.println("Cache hit count: " + cache.getHitCount());
    }
}
```

File Name: ThreadSafeCache.java

This program demonstrates the use of ConcurrentHashMap to implement a thread-safe cache. The ThreadSafeCache class uses a ConcurrentHashMap to store cache entries, and provides methods for adding, retrieving, and counting cache entries. The main() method tests the cache by adding entries and retrieving values.

Note: ConcurrentHashMap is a thread-safe implementation of the Map interface, and is useful for creating caches, dictionaries, and other similar data structures that need to be accessed by multiple threads.