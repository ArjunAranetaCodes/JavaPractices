import java.util.HashMap;

public class HashMapSample {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Java", "Programming");
        map.put("Python", "Scripting");
        map.put("C++", "OOP");

        // Checking if a key exists
        String keyToCheck = "Java";
        if (map.containsKey(keyToCheck)) {
            System.out.println(keyToCheck + " is present. Value: " + map.get(keyToCheck));
        } else {
            System.out.println(keyToCheck + " is not present in the HashMap.");
        }
    }
}
