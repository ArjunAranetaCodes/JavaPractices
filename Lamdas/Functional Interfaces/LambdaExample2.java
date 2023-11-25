import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LambdaExample2 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Doe", "Alice", "Bob");
        Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
        System.out.println(names);
    }
}
