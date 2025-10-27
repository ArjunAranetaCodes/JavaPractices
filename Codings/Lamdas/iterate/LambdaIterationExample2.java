import java.util.HashMap;
import java.util.Map;

public class LambdaIterationExample2 {
    public static void main(String[] args) {
        Map<String, Integer> ages = new HashMap<>();
        ages.put("John", 25);
        ages.put("Jane", 30);
        ages.put("Bob", 22);

        // Using lambda expression to iterate through the map
        ages.forEach((name, age) -> System.out.println(name + " is " + age + " years old."));
    }
}
