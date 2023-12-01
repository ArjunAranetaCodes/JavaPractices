import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JoinStrings {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "kiwi", "grape");
        String result = words.stream().collect(Collectors.joining(", "));
        System.out.println(result);
    }
}
