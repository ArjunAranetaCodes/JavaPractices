import java.util.stream.Stream;

public class EmptyStreamCountExample {
    public static void main(String[] args) {
        Stream<String> emptyStream = Stream.empty();
        long count = emptyStream.count();
        System.out.println("Count of elements: " + count);
    }
}
