import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConcatenateStrings {
    public static void main(String[] args) {
        List<String> words1 = Arrays.asList("apple", "banana");
        List<String> words2 = Arrays.asList("kiwi", "grape");
        List<String> combinedWords = Stream.concat(words1.stream(), words2.stream()).collect(Collectors.toList());
        System.out.println(combinedWords);
    }
}
