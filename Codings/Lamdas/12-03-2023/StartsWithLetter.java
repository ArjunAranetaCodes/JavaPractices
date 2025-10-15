import java.util.Arrays;
import java.util.List;

public class StartsWithLetter {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "kiwi", "grape");
        boolean anyStartsWithA = words.stream().anyMatch(s -> s.startsWith("a"));
        System.out.println("Any word starts with 'a': " + anyStartsWithA);
    }
}
