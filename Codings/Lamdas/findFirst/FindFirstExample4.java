import java.util.OptionalInt;
import java.util.stream.IntStream;

public class FindFirstExample4 {
    public static void main(String[] args) {
        OptionalInt firstPrime = IntStream.rangeClosed(2, 20)
                .filter(num -> IntStream.rangeClosed(2, (int) Math.sqrt(num))
                        .allMatch(i -> num % i != 0))
                .findFirst();

        firstPrime.ifPresent(
                result -> System.out.println("First prime number: " + result)
        );
    }
}
