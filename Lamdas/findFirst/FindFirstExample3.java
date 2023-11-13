import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;

public class FindFirstExample3 {
    public static void main(String[] args) {
        int[] numbers = {3, 7, 1, 4, 2};
        OptionalInt firstSquare = Arrays.stream(numbers)
                .map(num -> num * num)
                .findFirst();

        firstSquare.ifPresent(
                result -> System.out.println("First square of a number: " + result)
        );
    }
}
