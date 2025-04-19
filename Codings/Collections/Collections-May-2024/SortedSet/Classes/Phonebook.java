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