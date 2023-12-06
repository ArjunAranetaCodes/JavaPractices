import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EvenNumbers {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        List<Integer> evenNumbers = Arrays.stream(numbers)
                .filter(n -> n % 2 == 0)
                .boxed()
                .collect(Collectors.toList());

        System.out.println("Even numbers: " + evenNumbers);
    }
}
