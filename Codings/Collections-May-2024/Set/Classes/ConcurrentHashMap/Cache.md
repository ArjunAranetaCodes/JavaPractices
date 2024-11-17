## Problem: 
Implementing a Thread-Safe Cache

## Description: 
Create a program that demonstrates the use of ConcurrentHashMap to implement a thread-safe cache.

## Input:

Put: "Key1", "Value1"

Put: "Key2", "Value2"

Get: "Key1"

Get: "Key2"

## Output:

Value1

Value2

## Code Answer:
```Java
import java.util.concurrent.ConcurrentHashMap;

public class Cache {
    private ConcurrentHashMap<String, String> cache = new ConcurrentHashMap<>();

    public void put(String key, String value) {
        cache.put(key, value);
    }

    public String get(String key) {
        return cache.get(key);
    }

    public static void main(String[] args) {
        Cache cache = new Cache();

        Thread thread1 = new Thread(() -> {
            cache.put("Key1", "Value1");
        });

        Thread thread2 = new Thread(() -> {
            cache.put("Key2", "Value2");
        });

        Thread thread3 = new Thread(() -> {
            System.out.println(cache.get("Key1"));
        });

        Thread thread4 = new Thread(() -> {
            System.out.println(cache.get("Key2"));
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
```

File Name: Cache.java

This program demonstrates the use of ConcurrentHashMap to implement a thread-safe cache. The Cache class uses a ConcurrentHashMap to store key-value pairs, which ensures that multiple threads can safely access and modify the cache without fear of concurrent modification exceptions. The main method creates four threads that put and get values from the cache, demonstrating the thread safety of the cache.
Note: ConcurrentHashMap is a thread-safe implementation of a hash map, which allows multiple threads to access and modify the map simultaneously without fear of concurrent modification exceptions.