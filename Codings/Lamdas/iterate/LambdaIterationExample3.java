import java.util.HashSet;
import java.util.Set;

public class LambdaIterationExample3 {
    public static void main(String[] args) {
        Set<String> colors = new HashSet<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");

        // Using lambda expression to iterate through the set
        colors.forEach(color -> System.out.println("Color: " + color));
    }
}
