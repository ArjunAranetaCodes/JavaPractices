import java.util.Arrays;
import java.util.List;

public class MaxExample1 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 5, 2, 8, 3);
        Integer maxNumber = numbers.stream().max((a, b) -> a.compareTo(b)).orElse(null);
        System.out.println("Maximum number: " + maxNumber);
    }
}
