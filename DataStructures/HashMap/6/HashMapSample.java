import java.util.HashMap;
import java.util.Map;

public class HashMapSample {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 30);

        // Checking if a value exists
        int valueToCheck = 20;
        if (map.containsValue(valueToCheck)) {
            System.out.println(valueToCheck + " exists in the HashMap.");
        } else {
            System.out.println(valueToCheck + " does not exist in the HashMap.");
        }
    }
}
