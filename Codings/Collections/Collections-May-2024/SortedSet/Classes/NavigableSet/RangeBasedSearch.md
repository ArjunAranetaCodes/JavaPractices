## Problem: 
Implementing a Range-Based Search

## Description: 
Create a program that demonstrates the use of NavigableSet to implement a range-based search.

## Input:

Numbers: [1, 3, 5, 7, 9, 11, 13, 15]

Range: [5, 12]

## Output:

Numbers in range: [5, 7, 9, 11]

## Code Answer:

```Java
import java.util.*;

public class RangeBasedSearch {
public static void main(String[] args) {
NavigableSet<Integer> numbers = new TreeSet<>(Arrays.asList(1, 3, 5, 7, 9, 11, 13, 15));
int start = 5;
int end = 12;

        NavigableSet<Integer> range = numbers.subSet(start, true, end, true);

        System.out.println("Numbers in range: " + range);
    }
}
```

File Name: RangeBasedSearch.java

This program demonstrates the use of NavigableSet to implement a range-based search. The NavigableSet class uses a tree for storage, and it provides methods for navigating and searching the elements in the set. The subSet method is used to get a view of the portion of the set whose elements range from start to end.

Note: NavigableSet is a collection that stores elements in a sorted order, and it provides methods for navigating and searching the elements in the set. It is useful for implementing range-based searches and other similar operations.