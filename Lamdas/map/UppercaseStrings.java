import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UppercaseStrings {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "orange");
        List<String> uppercaseWords = words.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println("Original List: " + words);
        System.out.println("Uppercase List: " + uppercaseWords);
    }
}
