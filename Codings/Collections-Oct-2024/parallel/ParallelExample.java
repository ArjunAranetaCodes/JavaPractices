import java.util.stream.IntStream;

public class ParallelExample {
    public static void main(String[] args) {
        // Create a large array of numbers
        int[] numbers = IntStream.range(0, 1000000).toArray();

        // Perform a parallel operation on the array
        long startTime = System.currentTimeMillis();
        int sum = IntStream.of(numbers).parallel().sum();
        long endTime = System.currentTimeMillis();

        System.out.println("Sum: " + sum);
        System.out.println("Time taken: " + (endTime - startTime) + "ms");
    }
}