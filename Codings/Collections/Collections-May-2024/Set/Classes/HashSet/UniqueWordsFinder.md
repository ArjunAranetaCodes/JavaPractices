## Problem: 
Finding Unique Words in a Text

## Description: 
Create a program that demonstrates the use of HashSet to find unique words in a given text.

## Input:

Text: "Hello world, hello again, world!"

## Output:

Unique words: ["Hello", "world", "again"]

## Code Answer:

```Java
import java.util.*;

public class UniqueWordsFinder {
    public static void main(String[] args) {
        String text = "Hello world, hello again, world!";

        // Split the text into words
        String[] words = text.split("\\s+");

        // Use a HashSet to find unique words
        Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));

        System.out.println("Unique words: " + uniqueWords);
    }
}
```

File Name: UniqueWordsFinder.java

This program demonstrates the use of HashSet to find unique words in a given text. The main method splits the text into words, uses a HashSet to find unique words, and then prints the unique words.
Note: HashSet is a collection that stores unique elements, and it uses a hash table for storage. It is useful for storing a collection of unique elements and for testing membership. In this example, it is used to find unique words in a text.