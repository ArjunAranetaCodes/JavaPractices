import java.util.Arrays;
import java.util.List;

public class ForEachOrderedExample2 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("banana", "apple", "grape", "orange");

        // Using forEachOrdered to print sorted elements
        words.stream().sorted().forEachOrdered(word -> System.out.print(word + " "));
    }
}
