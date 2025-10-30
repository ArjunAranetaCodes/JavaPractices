import java.util.Arrays;
import java.util.List;

public class SkipExample1 {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("Apple", "Banana", "Orange", "Grapes", "Mango");

        fruits.stream()
                .skip(2)
                .forEach(System.out::println);
    }
}
