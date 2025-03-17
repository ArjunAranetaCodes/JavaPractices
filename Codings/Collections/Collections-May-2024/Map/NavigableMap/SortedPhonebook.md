## Problem: 
Implementing a Sorted Phonebook

## Description: 
Create a program that demonstrates the use of NavigableMap to implement a sorted phonebook.

## Input:

Names and phone numbers: {"John Doe", "123-456-7890"}, {"Alice Smith", "987-654-3210"}, {"Bob Johnson", "555-123-4567"}

## Output:

Phonebook:

Alice Smith = 987-654-3210

Bob Johnson = 555-123-4567

John Doe = 123-456-7890

First entry: Alice Smith = 987-654-3210

Last entry: John Doe = 123-456-7890

Ceiling entry for "Carol Davis": Bob Johnson = 555-123-4567

Floor entry for "Carol Davis": Alice Smith = 987-654-3210

## Code Answer:
```Java
import java.util.NavigableMap;
import java.util.TreeMap;

public class SortedPhonebook {
    private NavigableMap<String, String> phonebook;

    public SortedPhonebook() {
        this.phonebook = new TreeMap<>();
    }

    public void addEntry(String name, String phoneNumber) {
        phonebook.put(name, phoneNumber);
    }

    public String getPhoneNumber(String name) {
        return phonebook.get(name);
    }

    public static void main(String[] args) {
        SortedPhonebook phonebook = new SortedPhonebook();

        phonebook.addEntry("John Doe", "123-456-7890");
        phonebook.addEntry("Alice Smith", "987-654-3210");
        phonebook.addEntry("Bob Johnson", "555-123-4567");

        System.out.println("Phonebook:");
        for (Map.Entry<String, String> entry : phonebook.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        System.out.println("First entry: " + phonebook.firstEntry());
        System.out.println("Last entry: " + phonebook.lastEntry());
        System.out.println("Ceiling entry for \"Carol Davis\": " + phonebook.ceilingEntry("Carol Davis"));
        System.out.println("Floor entry for \"Carol Davis\": " + phonebook.floorEntry("Carol Davis"));
    }
}
```

File Name: SortedPhonebook.java

This program demonstrates the use of NavigableMap to implement a sorted phonebook. The SortedPhonebook class uses a TreeMap to store names and phone numbers. The addEntry method adds a new entry to the phonebook, and the getPhoneNumber method retrieves a phone number by name. The program prints the phonebook entries in sorted order by name, as well as the first and last entries, and the ceiling and floor entries for a given name ("Carol Davis" in this example).

Note: NavigableMap is a collection that stores key-value pairs in a sorted order, and it provides methods for navigating and searching the elements in the map. It is useful for implementing sorted dictionaries, phonebooks, and other similar data structures.