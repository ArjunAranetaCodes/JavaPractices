import java.util.Arrays;

public class MaxExample4 {
    public static void main(String[] args) {
        int[] array = {4, 8, 2, 10, 5};
        int maxElement = Arrays.stream(array).max().orElse(0);
        System.out.println("Maximum element in the array: " + maxElement);
    }
}
