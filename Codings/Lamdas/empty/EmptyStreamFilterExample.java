import java.util.stream.Stream;

public class EmptyStreamFilterExample {
    public static void main(String[] args) {
        Stream<String> emptyStream = Stream.empty();
        emptyStream.filter(s -> s.startsWith("A"))
                .forEach(System.out::println);
    }
}
