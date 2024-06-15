# Problem: 
"Sort List of Strings by Length and Alphabetically"

## Description: 
Write a Java program to sort a list of strings by their lengths in ascending order, and then alphabetically.

## Input:
A list of strings: ["apple", "banana", "cat", "dog", "elephant", "fish"]

## Output:
Sorted list: ["cat", "dog", "fish", "apple", "banana", "elephant"]

## Answer:
```
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortListByLengthAndAlphabetically {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("cat");
        list.add("dog");
        list.add("elephant");
        list.add("fish");

        Collections.sort(list, new StringComparator());

        System.out.println("Sorted list: " + list);
    }
}

class StringComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return Integer.compare(s1.length(), s2.length());
        } else {
            return s1.compareTo(s2);
        }
    }
}   
```

This program uses a custom comparator (StringComparator) to sort the list of strings by their lengths and then alphabetically. The Collections.sort method is used to sort the list. The StringComparator class implements the Comparator interface and provides a comparison method that compares the lengths and then the strings themselves.