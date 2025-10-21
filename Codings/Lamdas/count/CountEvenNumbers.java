import java.util.Arrays;
import java.util.List;

public class CountEvenNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        long evenCount = numbers.stream()
                .filter(n -> n % 2 == 0)
                .count();

        System.out.println("Count of even numbers: " + evenCount);
    }
}
