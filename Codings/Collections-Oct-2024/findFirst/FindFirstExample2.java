import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FindFirstExample2 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Mary", "David", "Emily");

        Optional<String> firstMatch = names.stream()
                .filter(name -> name.startsWith("D"))
                .findFirst();

        if (firstMatch.isPresent()) {
            System.out.println("First match: " + firstMatch.get());
        } else {
            System.out.println("No match found");
        }
    }
}