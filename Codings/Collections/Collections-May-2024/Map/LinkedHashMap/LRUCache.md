## Problem: 
Implementing an LRU (Least Recently Used) Cache

## Description: 
Create a program that demonstrates the use of LinkedHashMap to implement an LRU cache, which evicts the least recently used entry when the cache is full.

## Input:

Cache size: 3

Cache entries: {"Key1", "Value1"}, {"Key2", "Value2"}, {"Key3", "Value3"}, {"Key4", "Value4"}

## Output:

Cache entries:

Key1 = Value1

Key2 = Value2

Key3 = Value3

After accessing Key2:

Key2 = Value2

Key1 = Value1

Key3 = Value3

After adding Key4:

Key2 = Value2

Key3 = Value3

Key4 = Value4

## Code Answer:
```Java
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    private LinkedHashMap<String, String> cache;

    public LRUCache(int size) {
        cache = new LinkedHashMap<>(size, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                return size() > LRUCache.this.size;
            }
        };
    }

    public void put(String key, String value) {
        cache.put(key, value);
    }

    public String get(String key) {
        return cache.get(key);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);

        cache.put("Key1", "Value1");
        cache.put("Key2", "Value2");
        cache.put("Key3", "Value3");

        System.out.println("Cache entries:");
        for (Map.Entry<String, String> entry : cache.cache.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        cache.get("Key2");

        System.out.println("After accessing Key2:");
        for (Map.Entry<String, String> entry : cache.cache.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        cache.put("Key4", "Value4");

        System.out.println("After adding Key4:");
        for (Map.Entry<String, String> entry : cache.cache.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
```

File Name: LRUCache.java

This program demonstrates the use of LinkedHashMap to implement an LRU cache, which evicts the least recently used entry when the cache is full. The LRUCache class uses a LinkedHashMap with a custom implementation of the removeEldestEntry method to evict the least recently used entry when the cache is full. The main() method tests the cache by adding entries, accessing an entry, and adding a new entry.

Note: LinkedHashMap is used with a custom implementation of the removeEldestEntry method to implement an LRU cache. This is useful for creating caches, dictionaries, and other similar data structures that need to evict the least recently used entry when the cache is full.