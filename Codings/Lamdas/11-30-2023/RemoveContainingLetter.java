import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveContainingLetter {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "kiwi", "grape");
        List<String> filteredWords = words.stream().filter(s -> !s.contains("a")).collect(Collectors.toList());
        System.out.println(filteredWords);
    }
}
