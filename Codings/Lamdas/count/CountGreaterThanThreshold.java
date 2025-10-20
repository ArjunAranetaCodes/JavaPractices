import java.util.Arrays;
import java.util.List;

public class CountGreaterThanThreshold {
    public static void main(String[] args) {
        List<Double> values = Arrays.asList(1.5, 2.3, 3.8, 4.2, 5.1);

        long countGreaterThanThree = values.stream()
                .filter(x -> x > 3)
                .count();

        System.out.println("Count of elements greater than 3: " + countGreaterThanThree);
    }
}
