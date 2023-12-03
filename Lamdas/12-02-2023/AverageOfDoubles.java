import java.util.Arrays;
import java.util.List;

public class AverageOfDoubles {
    public static void main(String[] args) {
        List<Double> numbers = Arrays.asList(1.5, 2.7, 3.8, 2.0, 4.2);
        double average = numbers.stream().mapToDouble(Double::doubleValue).average().orElse(0);
        System.out.println("Average: " + average);
    }
}
