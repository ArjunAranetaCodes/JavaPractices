import java.util.HashSet;

public class HashSetSample {
    public static void main(String[] args) {
        HashSet<String> set1 = new HashSet<>();
        set1.add("Apple");
        set1.add("Banana");
        set1.add("Orange");

        HashSet<String> set2 = new HashSet<>();
        set2.add("Banana");
        set2.add("Grapes");
        set2.add("Pineapple");

        set1.retainAll(set2);

        System.out.println("Intersection of HashSet elements: " + set1);

        // Other HashSet operations can be performed here
    }
}
