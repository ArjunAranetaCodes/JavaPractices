## Problem: 
Implementing a Simple Duplicate Remover

## Description: 
Create a program that demonstrates the use of Set to remove duplicates from a list of strings.

## Input:
List: ["Hello", "World", "Hello", "Java", "World", "Java"]

## Output:
["Hello", "World", "Java"]

## Code Answer:
```Java
import java.util.*;

public class DuplicateRemover {
public static void main(String[] args) {
List<String> list = new ArrayList<>();
list.add("Hello");
list.add("World");
list.add("Hello");
list.add("Java");
list.add("World");
list.add("Java");

        Set<String> set = new HashSet<>(list);

        System.out.println(set);
    }
}
```

File Name: DuplicateRemover.java

This program demonstrates the use of Set to remove duplicates from a list of strings. The HashSet class is used to create a set from the list, which automatically removes duplicates. The resulting set is then printed to the console.