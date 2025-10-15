import java.util.Arrays;

public class IntegerSum {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};

        int sum = Arrays.stream(numbers).reduce(0, (x, y) -> x + y);

        System.out.println("Sum: " + sum);
    }
}
