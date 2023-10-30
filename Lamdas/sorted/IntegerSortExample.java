import java.util.Arrays;
import java.util.List;

public class IntegerSortExample {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(5, 2, 8, 1, 3);
        integerList.stream().sorted((i1, i2) -> i2.compareTo(i1)).forEach(System.out::println);
    }
}
