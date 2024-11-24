import java.util.stream.Stream;

public class PeekExample {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("apple", "banana", "cherry", "date", "elderberry");

        stream.peek(System.out::println) // print each element as it's processed
              .filter(s -> s.startsWith("c")) // filter elements starting with "c"
              .forEach(System.out::println); // print the filtered elements
    }
}