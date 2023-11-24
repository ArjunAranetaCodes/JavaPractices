import java.util.Random;
import java.util.function.Supplier;

public class LambdaExample7 {
    public static void main(String[] args) {
        Supplier<Integer> randomSupplier = () -> new Random().nextInt(100);
        System.out.println(randomSupplier.get());
    }
}
