import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        boolean randomBoolean = random.nextBoolean(); // Generates a random boolean value
        System.out.println("Random Boolean: " + randomBoolean);
    }
}
