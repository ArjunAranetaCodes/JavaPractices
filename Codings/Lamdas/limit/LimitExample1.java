import java.util.Arrays;
import java.util.List;

public class LimitExample1 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Using limit to get the first 5 elements
        numbers.stream()
                .limit(5)
                .forEach(System.out::println);
    }
}
