import java.util.Arrays;

public class AnyMatchExample5 {
    public static void main(String[] args) {
        int[] values = {10, 20, 30, 40, 50};

        boolean anyMatch = Arrays.stream(values).anyMatch(value -> isMultipleOfTen(value));

        System.out.println("Any value is a multiple of 10: " + anyMatch);
    }

    private static boolean isMultipleOfTen(int value) {
        return value % 10 == 0;
    }
}
// Output: Any value is a multiple of 10: true
