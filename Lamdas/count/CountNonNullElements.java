import java.util.Arrays;
import java.util.List;

public class CountNonNullElements {
    public static void main(String[] args) {
        List<String> items = Arrays.asList("apple", null, "banana", null, "orange");

        long countNonNull = items.stream()
                .filter(item -> item != null)
                .count();

        System.out.println("Count of non-null elements: " + countNonNull);
    }
}
