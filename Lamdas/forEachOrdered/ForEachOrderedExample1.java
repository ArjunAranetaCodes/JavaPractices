import java.util.Arrays;
import java.util.List;

public class ForEachOrderedExample1 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 3, 8, 1, 7);

        // Using forEachOrdered to print elements in order
        numbers.stream().forEachOrdered(num -> System.out.print(num + " "));
    }
}
