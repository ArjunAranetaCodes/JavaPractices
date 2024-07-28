import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ImmutableListExample {
    public static void main(String[] args) {
        List<String> names = Stream.of("Alice", "Bob", "Charlie")
                .collect(Collectors.toUnmodifiableList());

        System.out.println(names); // [Alice, Bob, Charlie]

        // Attempting to modify the list will throw UnsupportedOperationException
        names.add("David"); // throws UnsupportedOperationException
    }
}