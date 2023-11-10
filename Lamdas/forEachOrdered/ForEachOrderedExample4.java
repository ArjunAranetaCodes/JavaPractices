import java.util.Arrays;
import java.util.List;

public class ForEachOrderedExample4 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 3, 8, 1, 7);

        // Using forEachOrdered after filtering and mapping
        numbers.stream().filter(num -> num > 3).map(num -> num * 2).forEachOrdered(result -> System.out.print(result + " "));
    }
}
