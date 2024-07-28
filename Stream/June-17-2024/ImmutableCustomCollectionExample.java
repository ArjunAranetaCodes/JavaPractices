import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ImmutableCustomCollectionExample {
    public static void main(String[] args) {
        Collection<String> names = Stream.of("Alice", "Bob", "Charlie")
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        ImmutableCustomCollection::new
                ));

        System.out.println(names); // [Alice, Bob, Charlie]

        // Attempting to modify the collection will throw UnsupportedOperationException
        names.add("David"); // throws UnsupportedOperationException
    }

    private static class ImmutableCustomCollection<T> implements Collection<T> {
        private final Collection<T> delegate;

        public ImmutableCustomCollection(Collection<T> delegate) {
            this.delegate = delegate;
        }

        // Implement read-only methods by delegating to the underlying collection
        // Throw UnsupportedOperationException for mutating methods
    }
}