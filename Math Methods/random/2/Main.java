import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        double randomDouble = random.nextDouble(); // Generates a random double between 0.0 (inclusive) and 1.0 (exclusive)
        System.out.println("Random Double: " + randomDouble);
    }
}
 