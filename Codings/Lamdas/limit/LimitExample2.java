import java.util.Arrays;
import java.util.List;

public class LimitExample2 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "orange", "grape", "kiwi");

        // Using limit to filter strings with length less than or equal to 5
        words.stream()
                .filter(s -> s.length() <= 5)
                .limit(3)
                .forEach(System.out::println);
    }
}
