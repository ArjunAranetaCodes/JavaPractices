import java.util.*;

public class TreeMapSample {
    public static void main(String[] args) {
        TreeMap<String, Integer> treeMap = new TreeMap<>();

        treeMap.put("One", 1);
        treeMap.put("Two", 2);
        treeMap.put("Three", 3);

        // Removing element by key
        treeMap.remove("Two");

        System.out.println("TreeMap after removal: " + treeMap);
    }
}
