import java.util.Arrays;
import java.util.List;

public class LambdaIterationExample1 {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("Apple", "Banana", "Orange", "Mango");

        // Using lambda expression to iterate through the list
        fruits.forEach(fruit -> System.out.println(fruit));
    }
}
