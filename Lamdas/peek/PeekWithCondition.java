import java.util.stream.IntStream;

public class PeekWithCondition {
    public static void main(String[] args) {
        IntStream.rangeClosed(1, 10)
                .peek(n -> System.out.println("Checking number: " + n))
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);
    }
}
