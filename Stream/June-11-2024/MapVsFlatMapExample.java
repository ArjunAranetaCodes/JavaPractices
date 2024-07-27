import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapVsFlatMapExample {
    public static void main(String[] args) {
        // Example for map()
        List<String> names = Arrays.asList("John", "Jane", "Bob", "Alice");
        List<Integer> nameLengths = names.stream()
                                         .map(String::length)
                                         .collect(Collectors.toList());
        System.out.println("Name lengths using map(): " + nameLengths); // [4, 4, 3, 5]

        // Example for flatMap()
        List<List<Integer>> numberSets = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8, 9)
        );

        List<Integer> flattenedNumbers = numberSets.stream()
                                                   .flatMap(List::stream)
                                                   .collect(Collectors.toList());
        System.out.println("Flattened numbers using flatMap(): " + flattenedNumbers); // [1, 2, 3, 4, 5, 6, 7, 8, 9]

        // Another example for flatMap()
        List<String> words = Arrays.asList("Hello", "World", "Java", "Stream");
        List<String> characters = words.stream()
                                       .flatMap(word -> Arrays.stream(word.split("")))
                                       .filter(ch -> !ch.isEmpty())
                                       .distinct()
                                       .collect(Collectors.toList());
        System.out.println("Distinct characters using flatMap(): " + characters); // [H, e, l, o, W, r, d, J, a, v, S, t, m]
    }
}