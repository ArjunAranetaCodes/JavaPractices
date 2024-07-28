import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ImmutableMapExample {
    public static void main(String[] args) {
        Map<String, Integer> nameLengths = Stream.of("Alice", "Bob", "Charlie")
                .collect(Collectors.toUnmodifiableMap(
                        String::toString, // Key mapper
                        String::length    // Value mapper
                ));

        System.out.println(nameLengths); // {Alice=5, Bob=3, Charlie=7}

        // Attempting to modify the map will throw UnsupportedOperationException
        nameLengths.put("David", 5); // throws UnsupportedOperationException
    }
}