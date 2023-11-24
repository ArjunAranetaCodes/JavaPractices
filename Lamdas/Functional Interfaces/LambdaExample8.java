import java.util.HashMap;
import java.util.Map;

public class LambdaExample8 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);

        map.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
