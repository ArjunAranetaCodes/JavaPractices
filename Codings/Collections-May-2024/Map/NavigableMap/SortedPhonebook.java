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