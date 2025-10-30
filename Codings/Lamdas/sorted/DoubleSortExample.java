import java.util.Arrays;
import java.util.List;

public class DoubleSortExample {
    public static void main(String[] args) {
        List<Double> doubleList = Arrays.asList(5.3, 2.7, 8.1, 1.9, 3.5);
        doubleList.stream().sorted(Double::compareTo).forEach(System.out::println);
    }
}
