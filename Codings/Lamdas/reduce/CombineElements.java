import java.util.Arrays;
import java.util.List;

public class CombineElements {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Hello", " ", "World", "!");
        String combined = words.stream().reduce(String::concat).orElse("");
        System.out.println("Combined String: " + combined);
    }
}
