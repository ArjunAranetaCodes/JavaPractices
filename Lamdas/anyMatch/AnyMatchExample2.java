import java.util.stream.IntStream;

public class AnyMatchExample2 {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};

        boolean anyMatch = IntStream.of(numbers).anyMatch(num -> num % 2 == 0);

        System.out.println("Any even number: " + anyMatch);
    }
}
// Output: Any even number: true
