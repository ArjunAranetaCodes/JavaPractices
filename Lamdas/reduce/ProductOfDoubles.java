import java.util.Arrays;
import java.util.List;

public class ProductOfDoubles {
    public static void main(String[] args) {
        List<Double> doubles = Arrays.asList(1.5, 2.5, 3.0, 2.0);
        double product = doubles.stream().reduce(1.0, (a, b) -> a * b);
        System.out.println("Product of Doubles: " + product);
    }
}
