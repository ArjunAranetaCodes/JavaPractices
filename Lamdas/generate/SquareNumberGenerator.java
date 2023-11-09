import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SquareNumberGenerator {
    public static void main(String[] args) {
        List<Integer> squares = Stream.iterate(1, n -> n + 1)
                .map(x -> x * x)
                .limit(5)
                .collect(Collectors.toList());

        System.out.println("Squares: " + squares);
    }
}
