import java.util.Optional;
import java.util.stream.Stream;

public class EmptyStreamOptionalExample {
    public static void main(String[] args) {
        Stream<String> emptyStream = Stream.empty();
        Optional<String> result = emptyStream.findAny();
        System.out.println(result.orElse("No element found"));
    }
}
