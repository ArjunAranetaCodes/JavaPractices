import java.util.Arrays;
import java.util.List;

public class FindFirstExample {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");

        String firstFruitStartingWithC = fruits.stream()
                .filter(fruit -> fruit.startsWith("c"))
                .findFirst()
                .orElse("No fruit found");

        System.out.println("First fruit starting with C: " + firstFruitStartingWithC);
    }
}