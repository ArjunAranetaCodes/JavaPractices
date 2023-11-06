import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringLengths {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("cat", "dog", "elephant");
        List<Integer> lengths = words.stream()
                .map(String::length)
                .collect(Collectors.toList());

        System.out.println("Original List: " + words);
        System.out.println("Lengths List: " + lengths);
    }
}
