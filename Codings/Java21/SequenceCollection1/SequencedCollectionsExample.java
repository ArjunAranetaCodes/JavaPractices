import java.util.SequencedCollection;
import java.util.SequencedList;
import java.util.SequencedMap;
import java.util.SequencedSet;

public class SequencedCollectionsExample {
    public static void main(String[] args) {
        // Create a SequencedList
        SequencedList<String> sequencedList = new SequencedList<>();
        sequencedList.add("Apple");
        sequencedList.add("Banana");
        sequencedList.add("Cherry");

        // Access elements by index
        System.out.println(sequencedList.get(0)); // Apple
        System.out.println(sequencedList.get(1)); // Banana
        System.out.println(sequencedList.get(2)); // Cherry

        // Create a SequencedMap
        SequencedMap<String, Integer> sequencedMap = new SequencedMap<>();
        sequencedMap.put("Apple", 1);
        sequencedMap.put("Banana", 2);
        sequencedMap.put("Cherry", 3);

        // Access elements by key
        System.out.println(sequencedMap.get("Apple")); // 1
        System.out.println(sequencedMap.get("Banana")); // 2
        System.out.println(sequencedMap.get("Cherry")); // 3

        // Create a SequencedSet
        SequencedSet<String> sequencedSet = new SequencedSet<>();
        sequencedSet.add("Apple");
        sequencedSet.add("Banana");
        sequencedSet.add("Cherry");

        // Access elements by index (note: sets are not indexed, but SequencedSet allows it)
        System.out.println(sequencedSet.get(0)); // Apple
        System.out.println(sequencedSet.get(1)); // Banana
        System.out.println(sequencedSet.get(2)); // Cherry
    }
}