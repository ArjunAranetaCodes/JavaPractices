import java.util.stream.Stream;

public class StreamBuilderExample3 {
    public static void main(String[] args) {
        Stream<String> stream = Stream.<String>builder()
                .add("Apple")
                .add("Banana")
                .add("Orange")
                .add("Grape")
                .build();

        stream.filter(fruit -> fruit.startsWith("A"))
                .forEach(System.out::println);
    }
}
