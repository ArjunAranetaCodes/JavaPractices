import java.util.*;
import java.util.stream.*;

public class JavaStreamTutorial {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 2, 9, 1, 6, 3);

        // Filtering elements with filter()
        Stream<Integer> evenNumbers = numbers.stream().filter(n -> n % 2 == 0);
        evenNumbers.forEach(System.out::println);

        System.out.println();

        // Transforming elements with map()
        Stream<Integer> squareNumbers = numbers.stream().map(n -> n * n);
        squareNumbers.forEach(System.out::println);

        System.out.println();

        // Sorting elements with sorted()
        numbers.stream().sorted().forEach(System.out::println);

        System.out.println();

        // Custom sorting with sorted()
        numbers.stream().sorted((a, b) -> Integer.compare(b, a))
               .forEach(System.out::println);

        System.out.println();

        // Removing duplicates with distinct()
        List<String> words = Arrays.asList("hello", "world", "hello", "again");
        Stream<String> uniqueWords = words.stream().distinct();
        uniqueWords.forEach(System.out::println);
    }
}