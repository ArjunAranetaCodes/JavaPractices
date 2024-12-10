import java.util.HashMap;

public class HashMapSample {
    public static void main(String[] args) {
        // Creating a HashMap with chaining (LinkedList as the collision resolution strategy)
        HashMap<String, Integer> map = new HashMap<>(16, 0.75f);
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        map.put("Four", 4);
        map.put("Five", 5);
        map.put("Six", 6);

        // Displaying the HashMap
        System.out.println("HashMap with chaining: " + map);
    }
}
