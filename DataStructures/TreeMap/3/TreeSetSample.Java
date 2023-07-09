import java.util.*;

public class TreeMapSample {
    public static void main(String[] args) {
        TreeMap<String, Integer> treeMap = new TreeMap<>(Comparator.reverseOrder());

        treeMap.put("One", 1);
        treeMap.put("Two", 2);
        treeMap.put("Three", 3);

        System.out.println("TreeMap with Comparator: " + treeMap);
    }
}
