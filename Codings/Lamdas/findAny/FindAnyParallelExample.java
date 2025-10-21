import java.util.Arrays;

public class FindAnyParallelExample {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int result = Arrays.stream(numbers)
                .parallel()
                .filter(n -> n % 3 == 0)
                .findAny()
                .orElse(-1);

        System.out.println("Any number divisible by 3: " + result);
    }
}
