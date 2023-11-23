import java.util.Arrays;

public class AllMatchExample3 {
    public static void main(String[] args) {
        int[] numbers = { 1, 3, 5, 7, 9 };

        boolean allPositive = Arrays.stream(numbers).allMatch(num -> num > 0);

        System.out.println("Are all numbers positive? " + allPositive);
    }
}
