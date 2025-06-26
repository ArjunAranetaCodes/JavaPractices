import java.util.function.Function;

/**
 * Custom Template Processor Example
 * Demonstrates how to create and use custom template processors
 */
public class CustomTemplateProcessor {
    // Custom template processor that converts text to JSON format
    public static final Function<String, String> JSON = (String template) -> {
        return template.replace("\\{", "{")
                      .replace("\\}", "}")
                      .replace("\\\"", "\"");
    };

    // Custom template processor for SQL queries
    public static final Function<String, String> SQL = (String template) -> {
        return template.replace("\\{", "{")
                      .replace("\\}", "}")
                      .replace("'", "''"); // Escape single quotes for SQL
    };

    public static void main(String[] args) {
        // Example 1: JSON Template
        String name = "Alice";
        int age = 30;
        String city = "New York";
        
        String jsonTemplate = STR."""
            {
                "name": \{name},
                "age": \{age},
                "city": \{city}
            }
            """;
        
        String jsonOutput = JSON.apply(jsonTemplate);
        System.out.println("JSON Output:");
        System.out.println(jsonOutput);
        
        // Example 2: SQL Template
        String tableName = "users";
        String columnName = "age";
        int minAge = 25;
        
        String sqlTemplate = STR."""
            SELECT * FROM \{tableName}
            WHERE \{columnName} > \{minAge}
            ORDER BY name
            """;
        
        String sqlOutput = SQL.apply(sqlTemplate);
        System.out.println("\nSQL Output:");
        System.out.println(sqlOutput);
        
        // Example 3: Combining multiple processors
        String complexTemplate = STR."""
            {
                "query": \{SQL.apply(sqlTemplate)},
                "timestamp": \{System.currentTimeMillis()}
            }
            """;
        
        String finalOutput = JSON.apply(complexTemplate);
        System.out.println("\nCombined Output:");
        System.out.println(finalOutput);
    }
} 