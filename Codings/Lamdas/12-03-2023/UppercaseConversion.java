import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UppercaseConversion {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "kiwi", "grape");
        List<String> uppercaseWords = words.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(uppercaseWords);
    }
}
