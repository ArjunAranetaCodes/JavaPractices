import java.util.Arrays;
import java.util.List;

public class MinExample2 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "orange", "kiwi");
        String minLengthWord = words.stream().min((s1, s2) -> Integer.compare(s1.length(), s2.length())).orElse("");
        System.out.println("Shortest word: " + minLengthWord);
    }
}
