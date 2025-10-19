import java.util.Arrays;
import java.util.List;

public class AllMatchExample1 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 10);

        boolean allEven = numbers.stream().allMatch(num -> num % 2 == 0);

        System.out.println("Are all numbers even? " + allEven);
    }
}
