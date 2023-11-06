import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MultiplyByConstant {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 10);
        int constant = 3;
        List<Integer> multipliedNumbers = numbers.stream()
                .map(x -> x * constant)
                .collect(Collectors.toList());

        System.out.println("Original List: " + numbers);
        System.out.println("Multiplied List: " + multipliedNumbers);
    }
}
