import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SquareElements {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squaredNumbers = numbers.stream()
                .map(x -> x * x)
                .collect(Collectors.toList());

        System.out.println("Original List: " + numbers);
        System.out.println("Squared List: " + squaredNumbers);
    }
}
