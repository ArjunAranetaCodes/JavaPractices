## Problem: 
Implementing a Phonebook

## Description: 
Create a program that demonstrates the use of SortedSet to implement a phonebook.

## Input:

Names and phone numbers: ["John Doe", "123-456-7890"], ["Alice Smith", "987-654-3210"], ["Bob Johnson", "555-123-4567"]

## Output:

Phonebook:

Alice Smith: 987-654-3210

Bob Johnson: 555-123-4567

John Doe: 123-456-7890

## Code Answer:

```Java
import java.util.*;

public class Phonebook {
    private SortedSet<Map.Entry<String, String>> entries;

    public Phonebook() {
        this.entries = new TreeSet<>(new Comparator<Map.Entry<String, String>>() {
            @Override
            public int compare(Map.Entry<String, String> e1, Map.Entry<String, String> e2) {
                return e1.getKey().compareTo(e2.getKey());
            }
        });
    }

    public void addEntry(String name, String phoneNumber) {
        entries.add(new AbstractMap.SimpleEntry<>(name, phoneNumber));
    }

    public void printPhonebook() {
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();

        phonebook.addEntry("John Doe", "123-456-7890");
        phonebook.addEntry("Alice Smith", "987-654-3210");
        phonebook.addEntry("Bob Johnson", "555-123-4567");

        phonebook.printPhonebook();
    }
}
```

File Name: Phonebook.java

This program demonstrates the use of SortedSet to implement a phonebook. The Phonebook class uses a SortedSet to store entries (name and phone number pairs) in alphabetical order by name. The addEntry method adds a new entry to the phonebook, and the printPhonebook method prints all entries in the phonebook.
Note: SortedSet is a collection that stores elements in a sorted order, and it uses a tree for storage. It is useful for storing a collection of elements in a sorted order, making it suitable for implementing a phonebook.