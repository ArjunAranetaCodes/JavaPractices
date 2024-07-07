import java.util.*;

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