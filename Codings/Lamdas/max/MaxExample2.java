import java.util.Arrays;
import java.util.List;

public class MaxExample2 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("apple", "banana", "orange", "kiwi");
        String maxLengthString = strings.stream().max((s1, s2) -> s1.length() - s2.length()).orElse(null);
        System.out.println("String with maximum length: " + maxLengthString);
    }
}
