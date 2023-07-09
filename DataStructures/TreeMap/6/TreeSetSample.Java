import java.util.*;

public class TreeMapSample {
    public static void main(String[] args) {
        NavigableMap<Integer, String> navigableMap = new TreeMap<>();

        navigableMap.put(3, "Three");
        navigableMap.put(1, "One");
        navigableMap.put(2, "Two");

        System.out.println("First Entry: " + navigableMap.firstEntry());
    }
}
