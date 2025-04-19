## Problem: 
Implementing a Sorted List of Countries (by Name and then by Population)

## Description: 
Create a program that demonstrates the use of TreeSet to implement a sorted list of countries (by name and then by population).

## Input:

Countries: [{"USA", 331002651}, {"China", 1439323776}, {"India", 1380004385}, {"Indonesia", 273523615}]

## Output:

Sorted countries (by name and then by population):

China (1439323776)

India (1380004385)

Indonesia (273523615)

USA (331002651)

## Code Answer:
```Java
import java.util.*;

class Country implements Comparable<Country> {
String name;
int population;

    public Country(String name, int population) {
        this.name = name;
        this.population = population;
    }

    @Override
    public int compareTo(Country other) {
        int compareByName = this.name.compareTo(other.name);
        if (compareByName != 0) {
            return compareByName;
        } else {
            return Integer.compare(this.population, other.population);
        }
    }

    @Override
    public String toString() {
        return name + " (" + population + ")";
    }
}

public class SortedCountryList {
    public static void main(String[] args) {
        TreeSet<Country> countries = new TreeSet<>();

        countries.add(new Country("USA", 331002651));
        countries.add(new Country("China", 1439323776));
        countries.add(new Country("India", 1380004385));
        countries.add(new Country("Indonesia", 273523615));

        System.out.println("Sorted countries (by name and then by population):");
        for (Country country : countries) {
            System.out.println(country);
        }
    }
}
```

File Name: SortedCountryList.java

This program demonstrates the use of TreeSet to implement a sorted list of countries (by name and then by population). The Country class implements the Comparable interface to compare countries by name and then by population. The TreeSet class uses a tree for storage, and it provides methods for navigating and searching the elements in the set.

Note: TreeSet is a collection that stores elements in a sorted order, and it uses a tree for storage. It is useful for implementing sorted and unique lists, and other similar operations.