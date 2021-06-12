import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 9, 1, 6, 4);
        int min = Collections.min(numbers);
        System.out.println("Minimum value in the list: " + min);
    }
}
