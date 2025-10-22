import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapExample2 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("java", "stream", "flatMap", "example");

        List<String> result = words.stream()
                .filter(word -> word.length() > 4)
                .flatMap(str -> Arrays.stream(str.split("")))
                .collect(Collectors.toList());

        System.out.println(result);
    }
}
