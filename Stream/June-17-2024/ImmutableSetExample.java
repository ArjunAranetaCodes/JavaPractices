import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ImmutableSetExample {
    public static void main(String[] args) {
        Set<String> names = Stream.of("Alice", "Bob", "Charlie", "Alice")
                .collect(Collectors.toUnmodifiableSet());

        System.out.println(names); // [Bob, Alice, Charlie]

        // Attempting to modify the set will throw UnsupportedOperationException
        names.add("David"); // throws UnsupportedOperationException
    }
}