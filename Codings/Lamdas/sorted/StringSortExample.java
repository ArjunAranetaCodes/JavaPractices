import java.util.Arrays;
import java.util.List;

public class StringSortExample {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("banana", "apple", "orange", "grape");
        stringList.stream().sorted((s1, s2) -> s1.compareTo(s2)).forEach(System.out::println);
    }
}
