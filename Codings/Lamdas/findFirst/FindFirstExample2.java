import java.util.Arrays;
import java.util.Optional;

public class FindFirstExample2 {
    public static void main(String[] args) {
        String[] words = {"Apple", "Banana", "Orange", "Apricot", "Mango"};
        Optional<String> startsWithA = Arrays.stream(words)
                .filter(word -> word.startsWith("A"))
                .findFirst();

        startsWithA.ifPresent(
                result -> System.out.println("First word starting with 'A': " + result)
        );
    }
}
