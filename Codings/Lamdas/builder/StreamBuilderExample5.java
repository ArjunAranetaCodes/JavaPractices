import java.util.stream.IntStream;

public class StreamBuilderExample5 {
    public static void main(String[] args) {
        IntStream stream = IntStream.builder()
                .add(1)
                .add(2)
                .add(3)
                .build();

        stream.map(x -> x * x)
                .forEach(System.out::println);
    }
}
