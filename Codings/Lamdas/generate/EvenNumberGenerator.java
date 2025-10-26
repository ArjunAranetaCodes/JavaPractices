import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EvenNumberGenerator {
    public static void main(String[] args) {
        List<Integer> evenNumbers = Stream.iterate(2, n -> n + 2)
                .limit(5)
                .collect(Collectors.toList());

        System.out.println("Even Numbers: " + evenNumbers);
    }
}
