import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an angle in degrees: ");
        double angleInDegrees = scanner.nextDouble();
        double angleInRadians = Math.toRadians(angleInDegrees);
        double sinValue = Math.sin(angleInRadians);
        System.out.println("Sine of " + angleInDegrees + " degrees: " + sinValue);
    }
}
   