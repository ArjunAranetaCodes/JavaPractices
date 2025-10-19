import java.util.Arrays;
import java.util.List;

public class DistinctIntegers {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 2, 3, 5, 6, 1);

        // Using distinct() with lambda expression to get distinct integers
        numbers.stream()
                .distinct()
                .forEach(System.out::println);
    }
}
