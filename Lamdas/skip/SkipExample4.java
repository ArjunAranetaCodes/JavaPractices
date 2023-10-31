import java.util.Arrays;

public class SkipExample4 {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Arrays.stream(numbers)
                .parallel()
                .skip(2)
                .forEach(System.out::println);
    }
}
