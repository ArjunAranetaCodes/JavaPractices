import java.util.HashMap;
import java.util.Map;

public class HashMapSample {
    public static void main(String[] args) {
        HashMap<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);

        HashMap<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);

        // Merging two HashMaps
        map1.putAll(map2);

        // Displaying the merged HashMap
        System.out.println("Merged HashMap: " + map1);
    }
}
