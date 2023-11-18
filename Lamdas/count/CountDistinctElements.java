import java.util.Arrays;
import java.util.List;

public class CountDistinctElements {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 2, 4, 5, 3, 6, 7, 8, 6);

        long countDistinct = numbers.stream()
                .distinct()
                .count();

        System.out.println("Count of distinct elements: " + countDistinct);
    }
}
