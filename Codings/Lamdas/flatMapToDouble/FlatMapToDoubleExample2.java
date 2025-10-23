import java.util.Arrays;

public class FlatMapToDoubleExample2 {
    public static void main(String[] args) {
        // Example: Transform a list of integers to a double stream
        Arrays.asList(1, 2, 3, 4, 5)
                .stream()
                .flatMapToDouble(x -> Arrays.stream(new double[]{x, x * 2.0}))
                .forEach(System.out::println);
    }
}
