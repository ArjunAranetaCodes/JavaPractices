import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamConcatExample {
    public static void main(String[] args) {

        IntStream stream1 = IntStream.of(1, 2, 3);
        IntStream stream2 = IntStream.of(4,5);

        Stream<Integer> concat = Stream.concat(stream1.mapToObj(i -> i), stream2.mapToObj(i -> i));
        concat.forEach(System.out::println);
    }
}