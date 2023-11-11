import java.util.Arrays;

public class FlatMapToDoubleExample1 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        double sumOfSquares = Arrays.stream(matrix)
                .flatMapToDouble(row -> Arrays.stream(row).mapToDouble(num -> num * num))
                .sum();

        System.out.println("Sum of squares: " + sumOfSquares);
    }
}
