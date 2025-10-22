import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapExample3 {
    public static void main(String[] args) {
        List<int[]> numberPairs = Arrays.asList(new int[]{1, 2}, new int[]{3, 4}, new int[]{5, 6});

        List<Integer> flattenedNumbers = numberPairs.stream()
                .flatMapToInt(Arrays::stream)
                .boxed()
                .collect(Collectors.toList());

        System.out.println(flattenedNumbers);
    }
}
