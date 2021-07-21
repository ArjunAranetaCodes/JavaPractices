import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        double randomNumber = random.nextDouble() * 100; // Generate a random double between 0 and 100
        double floorValue = Math.floor(randomNumber);

        System.out.println("Random Number: " + randomNumber);
        System.out.println("Floor Value: " + floorValue);
    }
}
 