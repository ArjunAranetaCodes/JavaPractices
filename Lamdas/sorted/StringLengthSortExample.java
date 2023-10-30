import java.util.Arrays;
import java.util.List;

public class StringLengthSortExample {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("apple", "banana", "orange", "grape");
        stringList.stream().sorted((s1, s2) -> Integer.compare(s1.length(), s2.length())).forEach(System.out::println);
    }
}
