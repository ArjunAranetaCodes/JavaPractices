import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapExample1 {
    public static void main(String[] args) {
        List<List<String>> nestedList = Arrays.asList(
                Arrays.asList("apple", "banana"),
                Arrays.asList("orange", "grape"),
                Arrays.asList("melon", "kiwi")
        );

        List<String> flattenedList = nestedList.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        System.out.println(flattenedList);
    }
}
