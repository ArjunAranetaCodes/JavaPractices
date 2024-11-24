import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MinExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(7, 2, 3, 4, 5);

        Optional<Integer> min1 = numbers.stream().min(Integer::compareTo);

        System.out.println("Minimum value: " + min1.get());
    }
}