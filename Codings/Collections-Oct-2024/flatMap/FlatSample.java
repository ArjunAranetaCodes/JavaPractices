import java.util.stream.Stream;
import java.util.*;

public class FlatSample {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        list.stream().map(i -> (i * 2)).forEach(System.out::println);
    }
}