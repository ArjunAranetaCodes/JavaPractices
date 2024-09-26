import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int sum = IntStream.rangeClosed(1, 100)
                           .filter(n -> n % 2 == 0)
                           .sum();
        System.out.println("Sum of even numbers between 1 and 100 is: " + sum);
    }
}