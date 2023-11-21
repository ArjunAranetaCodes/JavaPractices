import java.util.stream.IntStream;

public class StreamBuilderExample2 {
    public static void main(String[] args) {
        IntStream stream = IntStream.builder()
                .add(1)
                .add(2)
                .add(3)
                .build();

        stream.forEach(System.out::println);
    }
}
