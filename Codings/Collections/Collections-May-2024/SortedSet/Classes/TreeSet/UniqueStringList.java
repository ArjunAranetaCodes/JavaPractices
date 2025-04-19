import java.util.*;

public class UniqueStringList {
    public static void main(String[] args) {
        TreeSet<String> uniqueStrings = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

        uniqueStrings.add("Hello");
        uniqueStrings.add("world");
        uniqueStrings.add("HELLO");
        uniqueStrings.add("World");
        uniqueStrings.add("java");
        uniqueStrings.add("Java");

        System.out.println("Unique strings (case-insensitive):");
        for (String str : uniqueStrings) {
            System.out.println(str);
        }
    }
}