import java.util.HashSet;

public class HashSetSample {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("One");
        set.add("Two");
        set.add("Three");

        String elementToCheck = "Two";
        System.out.println("Does HashSet contain '" + elementToCheck + "'? " + set.contains(elementToCheck));

        // Other HashSet operations can be performed here
    }
}
