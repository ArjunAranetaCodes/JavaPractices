import java.util.HashSet;

public class HashSetSample {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();

        System.out.println("Is HashSet empty? " + set.isEmpty());

        set.add("Java");
        System.out.println("Is HashSet empty now? " + set.isEmpty());

        // Other HashSet operations can be performed here
    }
}
