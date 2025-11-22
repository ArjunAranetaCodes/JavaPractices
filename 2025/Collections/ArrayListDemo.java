/**
 * Tutorial: ArrayList
 * Demonstrates ArrayList operations
 */
import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListDemo {
    public static void main(String[] args) {
        // Create ArrayList
        ArrayList<String> list = new ArrayList<>();
        
        // Add elements
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        list.add(1, "Orange");  // Insert at index
        
        System.out.println("List: " + list);
        
        // Access elements
        System.out.println("Element at index 0: " + list.get(0));
        System.out.println("Size: " + list.size());
        
        // Check if contains
        System.out.println("Contains 'Apple': " + list.contains("Apple"));
        
        // Remove elements
        list.remove("Banana");
        list.remove(0);
        System.out.println("After removal: " + list);
        
        // Iterate
        System.out.println("\nIterating:");
        for (String fruit : list) {
            System.out.println(fruit);
        }
        
        // Using Iterator
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.println("Iterator: " + it.next());
        }
        
        // Clear
        list.clear();
        System.out.println("After clear: " + list);
    }
}
















