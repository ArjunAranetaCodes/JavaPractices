import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;

public class StreamSample1 {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("apple", "banana", "orange");
        stream.forEach(System.out::println);

        System.out.println("---");
        List<String> fruits = Arrays.asList("apple", "banana", "orange");
        List<Integer> fruitLengths = fruits.stream().map(String::length).collect(Collectors.toList());
        System.out.println(fruitLengths);

        List<List<Integer>> multiList = Arrays.asList(
            Arrays.asList(1,2,3),
            Arrays.asList(4,5,6),
            Arrays.asList(7,8,9)
        );
        List<Integer> flatList = multiList.stream().flatMap(List::stream).collect(Collectors.toList());
        System.out.println(flatList);
    }
}