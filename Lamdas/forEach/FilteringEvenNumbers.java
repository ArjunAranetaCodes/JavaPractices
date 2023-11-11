import java.util.Arrays;
import java.util.List;

public class FilteringEvenNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Using forEach() to print only even numbers
        numbers.forEach(num -> {
            if (num % 2 == 0) {
                System.out.println(num);
            }
        });
    }
}
