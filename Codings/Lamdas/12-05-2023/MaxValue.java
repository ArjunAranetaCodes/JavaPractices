import java.util.Arrays;

public class MaxValue {
    public static void main(String[] args) {
        int[] numbers = {14, 3, 8, 20, 6, 1};

        int max = Arrays.stream(numbers).max().orElse(0);

        System.out.println("Maximum value: " + max);
    }
}
