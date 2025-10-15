//Exercise 2: Filtering Strings
//Description: Filter an array of strings to include only those that contain the letter 'a' using a lambda expression.

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringFilter {
    public static void main(String[] args) {
        String[] words = {"apple", "banana", "cherry", "date", "elderberry"};

        List<String> result = Arrays.stream(words)
                .filter(word -> word.contains("a"))
                .collect(Collectors.toList());

        System.out.println(result);
    }
}