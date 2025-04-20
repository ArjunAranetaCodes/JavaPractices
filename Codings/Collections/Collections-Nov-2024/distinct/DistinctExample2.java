import java.util.Arrays;
import java.util.List;

public class DistinctExample2 {
    public static void main(String[] args) {
        List<String> colors = Arrays.asList("Red", "Green", "Blue", "Red", "Yellow", "Green", "Purple");

        colors.stream()
                .distinct()
                .forEach(System.out::println);
    }
}