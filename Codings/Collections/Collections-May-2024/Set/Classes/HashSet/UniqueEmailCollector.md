## Problem: 
Implementing a Unique Email Address Collector

## Description: 
Create a program that demonstrates the use of HashSet to collect unique email addresses from a list of email addresses.

## Input:

Email addresses: ["email1@example.com", "email2@example.com", "email1@example.com", "email3@example.com"]

## Output:

Unique email addresses: ["email1@example.com", "email2@example.com", "email3@example.com"]

## Code Answer:
```Java
import java.util.*;

public class UniqueEmailCollector {
    public static void main(String[] args) {
        List<String> emailAddresses = Arrays.asList(
        "email1@example.com",
        "email2@example.com",
        "email1@example.com",
        "email3@example.com"
    );

        Set<String> uniqueEmailAddresses = new HashSet<>(emailAddresses);

        System.out.println("Unique email addresses: " + uniqueEmailAddresses);
    }
}
```

File Name: UniqueEmailCollector.java

This program demonstrates the use of HashSet to collect unique email addresses from a list of email addresses. The main method creates a list of email addresses, some of which are duplicates, and then uses a HashSet to collect the unique email addresses. The HashSet automatically removes duplicates, resulting in a set of unique email addresses.
Note: HashSet is a collection that stores unique elements, and it uses a hash table for storage. It is useful for storing a collection of unique elements and for testing membership.