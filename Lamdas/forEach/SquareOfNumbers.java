import java.util.Arrays;
import java.util.List;

public class SquareOfNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Using forEach() to square each number
        numbers.forEach(num -> System.out.println(num * num));
    }
}
