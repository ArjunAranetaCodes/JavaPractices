import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import java.util.stream.LongStream;

public class Main {
    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("1", "2", "3", "4", "5");
        LongStream longStream = stringStream.mapToLong(Long::parseLong);
        longStream.forEach(System.out::println);
    }
}