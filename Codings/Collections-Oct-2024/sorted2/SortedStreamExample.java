import java.util.Arrays;
import java.util.List;

public class SortedStreamExample {
    public static void main(String[] args) {
        // Create a list of integers
        List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 9);

        // Use sorted() to sort the list in ascending order
        List<Integer> sortedNumbers = numbers.stream()
                .sorted()
                .toList();

        // Print the sorted list
        System.out.println("Sorted numbers: " + sortedNumbers);
    }
}