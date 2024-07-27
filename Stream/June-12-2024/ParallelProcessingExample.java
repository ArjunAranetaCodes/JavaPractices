import java.util.Arrays;

public class ParallelProcessingExample {
    public static void main(String[] args) {
        // Create an array
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // Convert the array to a parallel stream
        Arrays.stream(numbers)
              .parallel()
              // Perform operations on each element
              .map(number -> number * 2)
              // Print the result
              .forEach(System.out::println);
    }
}