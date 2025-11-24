/**
 * Tutorial: HashSet
 * Demonstrates HashSet operations (no duplicates)
 */
import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo {
    public static void main(String[] args) {
        // Create HashSet
        HashSet<String> set = new HashSet<>();
        
        // Add elements
        set.add("Apple");
        set.add("Banana");
        set.add("Cherry");
        set.add("Apple");  // Duplicate, won't be added
        
        System.out.println("Set: " + set);
        System.out.println("Size: " + set.size());
        
        // Check if contains
        System.out.println("Contains 'Apple': " + set.contains("Apple"));
        
        // Remove
        set.remove("Banana");
        System.out.println("After removal: " + set);
        
        // Iterate
        System.out.println("\nIterating:");
        for (String fruit : set) {
            System.out.println(fruit);
        }
        
        // Using Iterator
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            System.out.println("Iterator: " + it.next());
        }
        
        // Clear
        set.clear();
        System.out.println("After clear: " + set.isEmpty());
    }
}


















