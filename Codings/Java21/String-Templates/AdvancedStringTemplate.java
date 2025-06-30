import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

/**
 * Advanced String Template Example
 * Demonstrates advanced features of Java 21's String Templates
 */
public class AdvancedStringTemplate {
    public static void main(String[] args) {
        // Example 1: Nested expressions
        String firstName = "John";
        String lastName = "Doe";
        String fullName = STR."\{firstName} \{lastName}";
        String greeting = STR."Hello, \{fullName.toUpperCase()}!";
        System.out.println("Nested Expression Example:");
        System.out.println(greeting);
        
        // Example 2: Using with collections
        List<String> fruits = List.of("Apple", "Banana", "Orange");
        String fruitList = STR."""
            Available Fruits:
            \{fruits.stream()
                   .map(fruit -> STR."  - \{fruit}")
                   .collect(java.util.stream.Collectors.joining("\n"))}
            """;
        System.out.println("\nCollection Example:");
        System.out.println(fruitList);
        
        // Example 3: Using with maps
        Map<String, Integer> scores = Map.of(
            "John", 85,
            "Alice", 92,
            "Bob", 78
        );
        String scoreReport = STR."""
            Score Report:
            \{scores.entrySet().stream()
                   .map(entry -> STR."  \{entry.getKey()}: \{entry.getValue()}")
                   .collect(java.util.stream.Collectors.joining("\n"))}
            """;
        System.out.println("\nMap Example:");
        System.out.println(scoreReport);
        
        // Example 4: Using with date/time
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timestamp = STR."""
            Current Time: \{now.format(formatter)}
            Day of Week: \{now.getDayOfWeek()}
            """;
        System.out.println("\nDate/Time Example:");
        System.out.println(timestamp);
        
        // Example 5: Conditional expressions
        int age = 25;
        String ageStatus = STR."""
            Age: \{age}
            Status: \{age >= 18 ? "Adult" : "Minor"}
            """;
        System.out.println("\nConditional Expression Example:");
        System.out.println(ageStatus);
    }
} 