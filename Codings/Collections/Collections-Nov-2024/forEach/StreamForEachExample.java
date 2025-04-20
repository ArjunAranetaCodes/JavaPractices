import java.util.Arrays;
import java.util.List;

public class StreamForEachExample {
    public static void main(String[] args) {
        // Create a list of numbers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Use forEach to print each number
        numbers.stream()
                .forEach(System.out::println);
    }
}