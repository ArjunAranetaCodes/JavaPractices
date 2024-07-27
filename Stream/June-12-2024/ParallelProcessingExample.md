To perform parallel processing on arrays in Java using streams, you can follow these steps:

1. Convert the array to a stream using `Arrays.stream(array)`.
2. Call the `parallel()` method on the stream to enable parallel processing.[1][4]

Here's an example program:

```java
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
```

In this example:

1. An integer array `numbers` is created.
2. The array is converted to a parallel stream using `Arrays.stream(numbers).parallel()`.
3. The `map()` operation is applied to each element of the stream in parallel, doubling the value.
4. The `forEach()` operation is used to print each transformed element.[1]

## When to Use Parallel Streams

While parallel streams can improve performance for large datasets, they may not always be beneficial due to the overhead of creating and managing multiple threads. Here are some factors to consider:

- **Data size**: Parallel streams are more effective for large datasets where the performance gain outweighs the overhead.
- **Operation complexity**: Computationally intensive operations benefit more from parallel processing than simple operations.
- **Data structure**: Arrays provide better memory locality and can be split evenly, making them more suitable for parallel processing than other data structures like linked lists.[3]

It's recommended to use parallel streams judiciously and measure the performance impact before and after parallelization to ensure it provides a tangible benefit.[2]

Citations:
[1] https://www.geeksforgeeks.org/perform-parallel-processing-on-arrays-in-java-using-streams/
[2] https://www.tutorialspoint.com/what-is-java-parallel-streams
[3] https://www.baeldung.com/java-when-to-use-parallel-stream
[4] https://stackoverflow.com/questions/40933362/how-can-i-create-a-parallel-stream-from-an-array
[5] https://liviutudor.com/2014/09/26/find-in-array-java-8-style/