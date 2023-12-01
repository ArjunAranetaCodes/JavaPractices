import java.util.Arrays;
import java.util.List;

public class MaxElement {
    public static void main(String[] args) {
        List<Double> numbers = Arrays.asList(1.5, 2.7, 3.8, 2.0, 4.2);
        double max = numbers.stream().mapToDouble(Double::doubleValue).max().orElse(0);
        System.out.println("Max: " + max);
    }
}
