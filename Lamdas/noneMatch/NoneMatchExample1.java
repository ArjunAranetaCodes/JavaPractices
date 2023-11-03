import java.util.Arrays;

public class NoneMatchExample1 {
    public static void main(String[] args) {
        int[] numbers = {2, 4, 6, 8, 10};

        boolean noneEven = Arrays.stream(numbers)
                .noneMatch(num -> num % 2 == 1);

        System.out.println("Are all elements even? " + noneEven);
    }
}
