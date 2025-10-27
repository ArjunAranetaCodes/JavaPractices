import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaExample6 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Doe", "Alice", "Bob");
        List<String> filteredNames = names.stream()
                .filter(name -> name.length() > 3)
                .collect(Collectors.toList());
        System.out.println(filteredNames);
    }
}
