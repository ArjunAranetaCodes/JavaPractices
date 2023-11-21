import java.util.stream.Stream;

public class StreamBuilderExample1 {
    public static void main(String[] args) {
        Stream<String> stream = Stream.<String>builder()
                .add("One")
                .add("Two")
                .add("Three")
                .build();

        stream.forEach(System.out::println);
    }
}
