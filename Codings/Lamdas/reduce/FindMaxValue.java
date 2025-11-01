import java.util.Arrays;
import java.util.List;

public class FindMaxValue {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(12, 45, 8, 27, 50);
        int max = numbers.stream().reduce(Integer.MIN_VALUE, (a, b) -> Integer.max(a, b));
        System.out.println("Maximum Value: " + max);
    }
}
