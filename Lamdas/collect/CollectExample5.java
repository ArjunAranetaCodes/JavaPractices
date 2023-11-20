import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectExample5 {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("apple", "banana", "orange", "grape");

        Map<String, Integer> fruitLengths = fruits.stream()
                .collect(Collectors.toMap(
                        fruit -> fruit,
                        String::length
                ));

        System.out.println("Original List: " + fruits);
        System.out.println("Fruit Lengths Map: " + fruitLengths);
    }
}
