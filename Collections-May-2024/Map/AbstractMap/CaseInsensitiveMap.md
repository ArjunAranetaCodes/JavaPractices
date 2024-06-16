## Problem: 
Implementing a Case-Insensitive Map

## Description: 
Create a program that demonstrates the use of AbstractMap to implement a case-insensitive map.

## Input:

Key-value pairs: {"John", "Doe"}, {"Alice", "Smith"}

## Output:

Case-insensitive map:

john = Doe

alice = Smith

JOHN = Doe

## Code Answer:
```Java
import java.util.AbstractMap;
import java.util.Map;
import java.util.HashMap;

public class CaseInsensitiveMap extends AbstractMap<String, String> {
    private Map<String, String> map = new HashMap<>();

    @Override
    public Set<Entry<String, String>> entrySet() {
        return map.entrySet();
    }

    @Override
    public String put(String key, String value) {
        return map.put(key.toLowerCase(), value);
    }

    @Override
    public String get(Object key) {
        return map.get(((String) key).toLowerCase());
    }

    public static void main(String[] args) {
        CaseInsensitiveMap map = new CaseInsensitiveMap();

        map.put("John", "Doe");
        map.put("Alice", "Smith");

        System.out.println("Case-insensitive map:");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        System.out.println("Getting value for key 'JOHN': " + map.get("JOHN"));
    }
}
```

File Name: CaseInsensitiveMap.java

This program demonstrates the use of AbstractMap to implement a case-insensitive map. The CaseInsensitiveMap class extends AbstractMap and overrides the entrySet(), put(), and get() methods to make the map case-insensitive. The main() method tests the map by adding key-value pairs and retrieving values using different cases.

Note: AbstractMap is an abstract class that provides a basic implementation of the Map interface. It is useful for creating custom map implementations.