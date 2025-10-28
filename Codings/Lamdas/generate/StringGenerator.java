import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringGenerator {
    public static void main(String[] args) {
        Stream<String> stringStream = Stream.generate(() -> "Hello, World!")
                .limit(5);

        System.out.println("Generated Strings: " + stringStream.collect(Collectors.toList()));
    }
}
