import java.util.Arrays;
import java.util.stream.Stream;

public class ConcatArrays {
    public static void main(String[] args) {
        String[] array1 = {"a", "b", "c"};
        String[] array2 = {"d", "e", "f"};

        Stream<String> stream = Stream.concat(Arrays.stream(array1), Arrays.stream(array2));
        stream.forEach(System.out::println);
    }
}