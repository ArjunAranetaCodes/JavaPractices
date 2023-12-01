import java.util.Arrays;
import java.util.List;

public class MinElement {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 5, 1, 8, 3);
        int min = numbers.stream().min(Integer::compareTo).orElse(0);
        System.out.println("Min: " + min);
    }
}
