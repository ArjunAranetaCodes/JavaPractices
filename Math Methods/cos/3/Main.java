import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        double randomAngle = random.nextDouble() * 360;
        double angleInRadians = Math.toRadians(randomAngle);
        double cosineValue = Math.cos(angleInRadians);
        System.out.println("Cosine value of a random angle (" + randomAngle + " degrees): " + cosineValue);
    }
}
