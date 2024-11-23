import java.util.stream.Stream;

public class StreamGenerateExample {
    public static void main(String[] args) {
        // Generate a stream of 10 random numbers
        Stream<Double> randomStream = Stream.generate(Math::random);

        // Limit the stream to 10 elements and print them
        randomStream.limit(10)
                     .forEach(System.out::println);
    }
}