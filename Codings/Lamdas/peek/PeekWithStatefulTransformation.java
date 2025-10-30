import java.util.stream.Stream;

public class PeekWithStatefulTransformation {
    public static void main(String[] args) {
        Stream.of("apple", "banana", "orange")
                .peek(s -> System.out.println("Original fruit: " + s))
                .map(s -> {
                    String modified = s.toUpperCase();
                    System.out.println("Modified fruit: " + modified);
                    return modified;
                })
                .forEach(System.out::println);
    }
}
