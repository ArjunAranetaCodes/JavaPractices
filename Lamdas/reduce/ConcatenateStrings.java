import java.util.Arrays;
import java.util.List;

public class ConcatenateStrings {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Java", "Lambda", "Reduce");
        String result = strings.stream().reduce("", (a, b) -> a + b);
        System.out.println("Concatenated String: " + result);
    }
}
