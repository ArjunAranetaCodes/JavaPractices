## Problem: 
Implementing a Dictionary

## Description: 
Create a program that demonstrates the use of SortedMap to implement a dictionary.

## Input:

Words and their meanings: {"apple", "a fruit"}, {"banana", "a yellow fruit"}, {"cherry", "a red fruit"}

## Output:

Dictionary:

apple = a fruit

banana = a yellow fruit

cherry = a red fruit

## Code Answer:
```Java
import java.util.SortedMap;
import java.util.TreeMap;

public class Dictionary {
private SortedMap<String, String> dictionary;

    public Dictionary() {
        this.dictionary = new TreeMap<>();
    }

    public void addWord(String word, String meaning) {
        dictionary.put(word, meaning);
    }

    public String getMeaning(String word) {
        return dictionary.get(word);
    }

    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();

        dictionary.addWord("apple", "a fruit");
        dictionary.addWord("banana", "a yellow fruit");
        dictionary.addWord("cherry", "a red fruit");

        System.out.println("Dictionary:");
        for (Map.Entry<String, String> entry : dictionary.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
```

File Name: Dictionary.java

This program demonstrates the use of SortedMap to implement a dictionary. The Dictionary class uses a TreeMap to store words and their meanings. The addWord method adds a new word and its meaning to the dictionary, and the getMeaning method retrieves the meaning of a word. The program prints the dictionary entries in sorted order by word.

Note: SortedMap is a collection that stores key-value pairs in a sorted order, and it provides methods for navigating and searching the elements in the map. It is useful for implementing sorted dictionaries, phonebooks, and other similar data structures.