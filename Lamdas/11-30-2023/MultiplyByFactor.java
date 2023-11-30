import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MultiplyByFactor {
    public static void main(String[] args) {
        List<Double> numbers = Arrays.asList(1.5, 2.7, 3.8, 2.0, 4.2);
        double factor = 2.0;
        List<Double> multipliedNumbers = numbers.stream().map(n -> n * factor).collect(Collectors.toList());
        System.out.println(multipliedNumbers);
    }
}
