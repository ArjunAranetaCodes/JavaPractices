import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Create a list of strings
        List<String> strings = new ArrayList<>();
        strings.add("hello");
        strings.add("world");
        strings.add("java");
        strings.add("streams");

        // Use stream() and collect() to convert the list to uppercase
        List<String> uppercaseStrings = strings.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        // Print the result
        System.out.println(uppercaseStrings);
    }
}