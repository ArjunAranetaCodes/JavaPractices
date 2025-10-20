import java.util.Arrays;
import java.util.List;

public class FindAnyStringExample {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date");

        String result = words.stream()
                .filter(s -> s.startsWith("b"))
                .findAny()
                .orElse("Not found");

        System.out.println("Any word starting with 'b': " + result);
    }
}
