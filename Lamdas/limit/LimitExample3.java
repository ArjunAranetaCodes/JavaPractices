import java.util.Random;
import java.util.stream.IntStream;

public class LimitExample3 {
    public static void main(String[] args) {
        // Generating and limiting random integers
        new Random().ints(1, 100)
                .limit(5)
                .forEach(System.out::println);
    }
}
