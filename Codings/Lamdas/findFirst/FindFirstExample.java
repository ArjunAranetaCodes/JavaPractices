import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;

public class FindFirstExample {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 5, 2, 4, 6};
        OptionalInt firstEven = Arrays.stream(numbers).filter(num -> num % 2 == 0).findFirst();

        firstEven.ifPresent(
                result -> System.out.println("First even number: " + result)
        );
    }
}
