import java.util.Arrays;
import java.util.List;

public class StreamCountExample {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");

        long count = fruits.stream()
                .filter(fruit -> fruit.startsWith("a"))
                .count();

        System.out.println("Number of fruits that start with 'a': " + count);
    }
}