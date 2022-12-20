import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {2, 4, 6, 8, 2, 6, 10, 12, 14, 8};
        int[] uniqueNumbers = Arrays.stream(numbers).distinct().toArray();

        System.out.println("Original Array: " + Arrays.toString(numbers));
    }
}
