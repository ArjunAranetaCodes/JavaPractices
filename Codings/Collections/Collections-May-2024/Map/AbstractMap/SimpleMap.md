## Problem: 
Implementing a Simple Map

## Description: 
Create a program that demonstrates the use of AbstractMap to implement a simple map.

## Input:

Key-value pairs: {"a", "1"}, {"b", "2"}, {"c", "3"}

## Output:

Simple map:

a = 1

b = 2

c = 3

## Code Answer:
```Java
import java.util.AbstractMap;
import java.util.Map;
import java.util.HashMap;

public class SimpleMap extends AbstractMap<String, String> {
    private Map<String, String> map = new HashMap<>();

    @Override
    public Set<Entry<String, String>> entrySet() {
        return map.entrySet();
    }

    @Override
    public String put(String key, String value) {
        return map.put(key, value);
    }

    @Override
    public String get(Object key) {
        return map.get(key);
    }

    public static void main(String[] args) {
        SimpleMap map = new SimpleMap();

        map.put("a", "1");
        map.put("b", "2");
        map.put("c", "3");

        System.out.println("Simple map:");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
```

File Name: SimpleMap.java

This program demonstrates the use of AbstractMap to implement a simple map. The SimpleMap class extends AbstractMap and overrides the entrySet(), put(), and get() methods to create a simple map. The main() method tests the map by adding key-value pairs and retrieving values.

Note: AbstractMap is an abstract class that provides a basic implementation of the Map interface. It is useful for creating custom map implementations.