import java.util.Arrays;

public class Example {
    public static void main(String[] args) {
        // Create an array of strings
        String[] strings = {"1", "2", "3", "4", "5"};

        // Use stream() and mapToInt() to convert the strings to integers and sum them up
        int sum = Arrays.stream(strings)
                .mapToInt(Integer::parseInt)
                .sum();

        System.out.println("Sum: " + sum);
    }
}