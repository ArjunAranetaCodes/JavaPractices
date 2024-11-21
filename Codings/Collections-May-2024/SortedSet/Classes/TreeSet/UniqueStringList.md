## Problem: 
Implementing a Unique List of Strings (Case-Insensitive)

## Description: 
Create a program that demonstrates the use of TreeSet to implement a unique list of strings (case-insensitive).

## Input:

Strings: ["Hello", "world", "HELLO", "World", "java", "Java"]

## Output:

Unique strings (case-insensitive):

Hello

Java

World

## Code Answer:
```Java
import java.util.*;

public class UniqueStringList {
public static void main(String[] args) {
TreeSet<String> uniqueStrings = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

        uniqueStrings.add("Hello");
        uniqueStrings.add("world");
        uniqueStrings.add("HELLO");
        uniqueStrings.add("World");
        uniqueStrings.add("java");
        uniqueStrings.add("Java");

        System.out.println("Unique strings (case-insensitive):");
        for (String str : uniqueStrings) {
            System.out.println(str);
        }
    }
}
```

File Name: UniqueStringList.java

This program demonstrates the use of TreeSet to implement a unique list of strings (case-insensitive). The TreeSet class uses a tree for storage, and it provides methods for navigating and searching the elements in the set. The String.CASE_INSENSITIVE_ORDER comparator is used to ignore case when comparing strings.

Note: TreeSet is a collection that stores elements in a sorted order, and it uses a tree for storage. It is useful for implementing sorted and unique lists, and other similar operations.