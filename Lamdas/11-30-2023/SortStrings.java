import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortStrings {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "kiwi", "grape");
        List<String> sortedWords = words.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedWords);
    }
}
