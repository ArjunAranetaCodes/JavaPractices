import java.util.HashMap;

public class HashMapSample {
    public static void main(String[] args) {
        // Creating a HashMap
        HashMap<String, Integer> map = new HashMap<>();

        // Adding key-value pairs
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);

        // Accessing values
        System.out.println("Value corresponding to key 'Two': " + map.get("Two"));

        // Removing a key-value pair
        map.remove("Three");

        // Iterating through the HashMap
        System.out.println("HashMap after removal:");
        for (String key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }
    }
}
