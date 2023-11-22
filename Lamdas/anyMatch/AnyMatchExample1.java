import java.util.Arrays;

public class AnyMatchExample1 {
    public static void main(String[] args) {
        String[] words = {"apple", "banana", "cherry", "date"};

        boolean anyMatch = Arrays.stream(words).anyMatch(word -> word.startsWith("c"));

        System.out.println("Any word starts with 'c': " + anyMatch);
    }
}
// Output: Any word starts with 'c': true
