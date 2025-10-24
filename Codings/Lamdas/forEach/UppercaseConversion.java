import java.util.Arrays;
import java.util.List;

public class UppercaseConversion {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "orange");

        // Using forEach() to convert each word to uppercase
        words.forEach(word -> System.out.println(word.toUpperCase()));
    }
}
