## Problem: 
Implementing a SimpleCacheSystem

## Description: 
Create a program that demonstrates the use of ArrayDeque to implement a simple cache system. The program should allow users to add items to the cache and retrieve items from the cache.

## Input:
User: Add Item 1

User: Add Item 2

User: Get Item 1

User: Add Item 3

User: Get Item 2

## Output:

Item 1 added to cache

Item 2 added to cache

Item 1 retrieved from cache

Item 3 added to cache

Item 2 retrieved from cache

## Code Answer:
```Java
import java.util.ArrayDeque;
import java.util.Deque;

public class CacheSystem {
private Deque<String> cache = new ArrayDeque<>(5);

    public void addItem(String item) {
        cache.addLast(item);
        System.out.println(item + " added to cache");
    }

    public String getItem(String item) {
        if (cache.contains(item)) {
            return cache.pollFirst();
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        CacheSystem cacheSystem = new CacheSystem();

        cacheSystem.addItem("Item 1");
        cacheSystem.addItem("Item 2");
        System.out.println(cacheSystem.getItem("Item 1"));
        cacheSystem.addItem("Item 3");
        System.out.println(cacheSystem.getItem("Item 2"));
    }
}
```

File Name: CacheSystem.java

This program demonstrates the use of ArrayDeque to implement a simple cache system. Users can add items to the cache using the addItem method, and retrieve items from the cache using the getItem method. The ArrayDeque is used to keep track of the items in the cache, and the pollFirst method is used to remove and return the first item in the queue when an item is retrieved from the cache.