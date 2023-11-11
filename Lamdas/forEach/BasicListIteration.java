import java.util.ArrayList;
import java.util.List;

public class BasicListIteration {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");

        // Using forEach() with lambda expression
        fruits.forEach(fruit -> System.out.println(fruit));
    }
}
