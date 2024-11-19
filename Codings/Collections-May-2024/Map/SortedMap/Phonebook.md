## Problem: 
Implementing a Phonebook

## Description: 
Create a program that demonstrates the use of SortedMap to implement a phonebook.

## Input:

Names and phone numbers: {"John Doe", "123-456-7890"}, {"Alice Smith", "987-654-3210"}, {"Bob Johnson", "555-123-4567"}

## Output:

Phonebook:

Alice Smith = 987-654-3210

Bob Johnson = 555-123-4567

John Doe = 123-456-7890

## Code Answer:
```Java
import java.util.SortedMap;
import java.util.TreeMap;

public class Phonebook {
    private SortedMap<String, String> phonebook;

    public Phonebook() {
        this.phonebook = new TreeMap<>();
    }

    public void addEntry(String name, String phoneNumber) {
        phonebook.put(name, phoneNumber);
    }

    public String getPhoneNumber(String name) {
        return phonebook.get(name);
    }

    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();

        phonebook.addEntry("John Doe", "123-456-7890");
        phonebook.addEntry("Alice Smith", "987-654-3210");
        phonebook.addEntry("Bob Johnson", "555-123-4567");

        System.out.println("Phonebook:");
        for (Map.Entry<String, String> entry : phonebook.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
```

File Name: Phonebook.java

This program demonstrates the use of SortedMap to implement a phonebook. The Phonebook class uses a TreeMap to store names and phone numbers. The addEntry method adds a new entry to the phonebook, and the getPhoneNumber method retrieves a phone number by name. The program prints the phonebook entries in sorted order by name.

Note: SortedMap is a collection that stores key-value pairs in a sorted order, and it provides methods for navigating and searching the elements in the map. It is useful for implementing sorted dictionaries, phonebooks, and other similar data structures.