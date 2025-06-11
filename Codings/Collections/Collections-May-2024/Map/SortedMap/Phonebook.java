import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Map;

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
        for (Map.Entry<String, String> entry : phonebook.phonebook.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}