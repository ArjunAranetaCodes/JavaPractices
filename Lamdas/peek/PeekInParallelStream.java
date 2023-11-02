import java.util.stream.IntStream;

public class PeekInParallelStream {
    public static void main(String[] args) {
        IntStream.rangeClosed(1, 5)
                .parallel()
                .peek(i -> System.out.println("Processing element in parallel: " + i))
                .forEach(System.out::println);
    }
}
