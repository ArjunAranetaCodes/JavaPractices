import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmptyStreamMapExample {
    public static void main(String[] args) {
        Stream<String> emptyStream = Stream.empty();
        List<String> result = emptyStream.map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(result);
    }
}
