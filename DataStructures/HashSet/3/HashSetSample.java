import java.util.HashSet;

public class HashSetSample {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("Apple");
        set.add("Banana");
        set.add("Orange");

        System.out.println("HashSet elements: " + set);

        set.remove("Banana");
        System.out.println("After removing 'Banana': " + set);

        // Other HashSet operations can be performed here
    }
}
