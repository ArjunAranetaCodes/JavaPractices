import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortedStreamExample {
    public static void main(String[] args) {
        // Create a list of integers
        List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 9);

        // Use sorted() to sort the list in ascending order
        List<Integer> sortedNumbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Sorted numbers: " + sortedNumbers);
    }
}