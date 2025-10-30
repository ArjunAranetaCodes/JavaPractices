import java.util.stream.Stream;

public class PeekWithTransformation {
    public static void main(String[] args) {
        Stream.of("apple", "banana", "orange")
                .peek(s -> System.out.println("Processing fruit: " + s))
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }
}
