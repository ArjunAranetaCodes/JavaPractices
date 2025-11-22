/**
 * Tutorial: HashMap
 * Demonstrates HashMap operations
 */
import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
    public static void main(String[] args) {
        // Create HashMap
        HashMap<String, Integer> map = new HashMap<>();
        
        // Add key-value pairs
        map.put("Alice", 25);
        map.put("Bob", 30);
        map.put("Charlie", 35);
        
        System.out.println("Map: " + map);
        
        // Get value
        System.out.println("Alice's age: " + map.get("Alice"));
        
        // Check if key exists
        System.out.println("Contains key 'Bob': " + map.containsKey("Bob"));
        System.out.println("Contains value 30: " + map.containsValue(30));
        
        // Update value
        map.put("Alice", 26);
        System.out.println("After update: " + map);
        
        // Remove
        map.remove("Bob");
        System.out.println("After removal: " + map);
        
        // Iterate
        System.out.println("\nIterating:");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        
        // Iterate keys
        for (String key : map.keySet()) {
            System.out.println("Key: " + key);
        }
        
        // Iterate values
        for (Integer value : map.values()) {
            System.out.println("Value: " + value);
        }
    }
}
















