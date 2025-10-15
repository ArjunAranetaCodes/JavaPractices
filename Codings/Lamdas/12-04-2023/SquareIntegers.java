import java.util.Arrays;

public class SquareIntegers {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};

        int[] squares = Arrays.stream(numbers)
                .map(n -> n * n)
                .toArray();

        System.out.println("Squared values: " + Arrays.toString(squares));
    }
}
