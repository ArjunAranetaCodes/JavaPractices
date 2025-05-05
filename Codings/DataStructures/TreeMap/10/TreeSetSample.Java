import java.util.*;

public class TreeMapSample {
    public static void main(String[] args) {
        TreeMap<Integer, String> treeMap = new TreeMap<>();

        treeMap.put(10, "Ten");
        treeMap.put(20, "Twenty");
        treeMap.put(30, "Thirty");
        treeMap.put(40, "Forty");
        treeMap.put(50, "Fifty");

        // Ceiling and Floor operations
        System.out.println("Ceiling Entry for key 25: " + treeMap.ceilingEntry(25));
        System.out.println("Floor Entry for key 35: " + treeMap.floorEntry(35));
    }
}
