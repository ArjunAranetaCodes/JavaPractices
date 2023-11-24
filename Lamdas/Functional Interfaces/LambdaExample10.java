import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

public class LambdaExample10 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.replaceAll((UnaryOperator<Integer>) n -> n * 2);
        System.out.println(numbers);
    }
}
