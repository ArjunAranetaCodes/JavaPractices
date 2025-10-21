import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FindAnyOptionalExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5);

        Optional<Integer> result = numbers.stream()
                .filter(n -> n > 5)
                .findAny();

        System.out.println("Any number greater than 5: " + result.orElse(-1));
    }
}
