import java.util.*;

public class RemoveElements {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>(Arrays.asList("apple", "banana", "orange")); // create an ArrayList with initial values
        
        fruits.remove(1); // remove element at index 1
        
        System.out.println("Fruits after removal: " + fruits);
    }
}