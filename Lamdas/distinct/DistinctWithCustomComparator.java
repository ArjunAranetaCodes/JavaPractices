import java.util.Arrays;
import java.util.List;

public class DistinctWithCustomComparator {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "orange", "banana", "Apple", "grape", "Orange");

        // Using distinct() with lambda expression and case-insensitive comparator
        words.stream()
                .distinct()
                .map(String::toLowerCase)
                .forEach(System.out::println);
    }
}
