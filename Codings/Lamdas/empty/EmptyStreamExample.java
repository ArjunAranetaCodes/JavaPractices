import java.util.stream.Stream;

public class EmptyStreamExample {
    public static void main(String[] args) {
        Stream<String> emptyStream = Stream.empty();
        emptyStream.forEach(System.out::println);
    }
}
