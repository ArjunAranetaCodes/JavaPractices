import java.util.HashMap;
import java.util.Map;

public class LimitExample4 {
    public static void main(String[] args) {
        Map<String, Integer> scores = new HashMap<>();
        scores.put("John", 80);
        scores.put("Alice", 95);
        scores.put("Bob", 75);
        scores.put("Eve", 88);

        // Using limit to get the top 2 entries based on scores
        scores.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(2)
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}
