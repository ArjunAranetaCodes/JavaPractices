## Problem: 
Implementing a Thread-Safe Cache

## Description: 
Create a program that demonstrates the use of CopyOnWriteArraySet to implement a thread-safe cache.

## Input:

Put: "Key1", "Value1"

Put: "Key2", "Value2"

Put: "Key3", "Value3"

## Output:

{"Key1": "Value1", "Key2": "Value2", "Key3": "Value3"}

## Code Answer:
```Java
import java.util.*;

public class Cache {
private CopyOnWriteArraySet<String> keys = new CopyOnWriteArraySet<>();
private Map<String, String> cache = new HashMap<>();

    public void put(String key, String value) {
        keys.add(key);
        cache.put(key, value);
    }

    public String get(String key) {
        return cache.get(key);
    }

    public void printCache() {
        System.out.println(cache);
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
            cache.put("Key3", "Value3");
        });

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        cache.printCache();
    }
}
```

File Name: Cache.java

This program demonstrates the use of CopyOnWriteArraySet to implement a thread-safe cache. The Cache class uses a CopyOnWriteArraySet to store cache keys, which ensures that multiple threads can safely add keys to the set without fear of concurrent modification exceptions. The main method creates three threads that put key-value pairs into the cache and then prints the cache using the printCache method.