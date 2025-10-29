import java.util.Arrays;

public class MinExample3 {
    public static void main(String[] args) {
        int[] array = {3, 9, 4, 7, 1};
        int minValue = Arrays.stream(array).min().orElse(0);
        System.out.println("Minimum value: " + minValue);
    }
}
