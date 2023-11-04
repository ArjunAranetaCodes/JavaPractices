import java.util.Arrays;
import java.util.List;

public class MinExample1 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 6);
        int minValue = numbers.stream().min(Integer::compareTo).orElse(0);
        System.out.println("Minimum value: " + minValue);
    }
}
