import java.util.Arrays;
import java.util.List;

public class CountStrings {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "orange", "grape", "kiwi");

        long countOfLengthFive = words.stream()
                .filter(s -> s.length() == 5)
                .count();

        System.out.println("Count of strings with length 5: " + countOfLengthFive);
    }
}
