import java.util.*;
import java.util.stream.*;
public class Test1{
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        List<Integer> doubled = numbers.stream()
         .map(n -> n * 2)
         .collect(Collectors.toList());

        System.out.println(numbers);
        System.out.println(doubled);

        List<String> sentence = Arrays.asList("Hello world", "World 1");
        List<String> words = sentence.stream()
         .flatMap(s -> Arrays.stream(s.split(" ")))
         .collect(Collectors.toList());
        System.out.println(words);

        sentence.stream()
        .flatMap(s -> Arrays.stream(s.split(" ")))
        .forEach(System.out::println);
    }
}