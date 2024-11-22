import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamReduceExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Example 1: Summing all numbers in the list
        int sum = numbers.stream()
                .reduce(0, (acc, num) -> acc + num);

        System.out.println("Sum: " + sum);

        // Example 2: Multiplying all numbers in the list
        int product = numbers.stream()
                .reduce(1, (acc, num) -> acc * num);

        System.out.println("Product: " + product);

        // Example 3: Finding the maximum number in the list
        int max = numbers.stream()
                .reduce(Integer::max)
                .orElse(-1);

        System.out.println("Max: " + max);

        // Example 4: Finding the minimum number in the list
        int min = numbers.stream()
                .reduce(Integer::min)
                .orElse(-1);

        System.out.println("Min: " + min);
    }
}