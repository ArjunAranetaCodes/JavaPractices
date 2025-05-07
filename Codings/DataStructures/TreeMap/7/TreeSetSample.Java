import java.util.*;

public class TreeMapSample {
    public static void main(String[] args) {
        TreeMap<Integer, String> treeMap = new TreeMap<>();

        treeMap.put(1, "One");
        treeMap.put(2, "Two");
        treeMap.put(3, "Three");
        treeMap.put(4, "Four");
        treeMap.put(5, "Five");

        // Creating submap from key 2 to key 4
        SortedMap<Integer, String> subMap = treeMap.subMap(2, 5);

        System.out.println("SubMap: " + subMap);
    }
}
