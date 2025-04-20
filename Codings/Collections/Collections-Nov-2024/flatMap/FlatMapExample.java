import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapExample {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("hello world", "this is a test", "java streams");

        List<String> flatMappedWords = words.stream()
                .flatMap(word -> Arrays.stream(word.split(" ")))
                .collect(Collectors.toList());

        System.out.println(flatMappedWords);
    }
}