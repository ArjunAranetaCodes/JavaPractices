import java.util.Arrays;
import java.util.List;

public class DistinctStrings {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "orange", "banana", "apple", "grape", "orange");

        // Using distinct() with lambda expression to get distinct strings
        words.stream()
                .distinct()
                .forEach(System.out::println);
    }
}
