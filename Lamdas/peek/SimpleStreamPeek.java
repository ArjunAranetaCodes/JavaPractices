import java.util.stream.Stream;

public class SimpleStreamPeek {
    public static void main(String[] args) {
        Stream.of(1, 2, 3, 4, 5)
                .peek(e -> System.out.println("Processing element: " + e))
                .forEach(System.out::println);
    }
}
