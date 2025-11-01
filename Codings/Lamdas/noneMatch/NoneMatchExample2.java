import java.util.stream.IntStream;

public class NoneMatchExample2 {
    public static void main(String[] args) {
        int[] values = {50, 75, 90, 110, 120};

        boolean noneGreaterThan100 = IntStream.of(values)
                .noneMatch(value -> value > 100);

        System.out.println("Are there no values greater than 100? " + noneGreaterThan100);
    }
}
