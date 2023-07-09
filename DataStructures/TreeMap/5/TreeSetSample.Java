import java.util.*;

public class TreeMapSample {
    public static void main(String[] args) {
        TreeMap<String, Integer> treeMap = new TreeMap<>();

        treeMap.put("One", 1);
        treeMap.put("Two", 2);
        treeMap.put("Three", 3);

        // Checking key existence
        String keyToCheck = "Two";
        System.out.println("Does TreeMap contain key '" + keyToCheck + "': " + treeMap.containsKey(keyToCheck));
    }
}
