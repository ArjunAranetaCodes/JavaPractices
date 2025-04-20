import java.util.HashSet;

public class HashSetSample {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("January");
        set.add("February");
        set.add("March");

        System.out.println("HashSet elements: " + set);

        set.clear();
        System.out.println("HashSet after clearing: " + set);

        // Other HashSet operations can be performed here
    }
}
