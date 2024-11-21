import java.util.Arrays;
import java.util.List;

public class AllMatchExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        
        boolean allEven = numbers.stream()
                .allMatch(num -> num % 2 == 0);
        
        System.out.println("All numbers are even: " + allEven);
        
        boolean allPositive = numbers.stream()
                .allMatch(num -> num > 0);
        
        System.out.println("All numbers are positive: " + allPositive);
    }
}