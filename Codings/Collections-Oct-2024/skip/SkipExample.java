import java.util.stream.IntStream;

public class SkipExample {
    public static void main(String[] args) {
        IntStream numbers = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers.skip(3) // skip the first 3 elements
                .forEach(System.out::println);
    }
}