import java.util.HashMap;
import java.util.Map;

public class HashMapSample {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");

        // Iterating through values
        System.out.println("Values in the HashMap:");
        for (String value : map.values()) {
            System.out.println(value);
        }
    }
}
