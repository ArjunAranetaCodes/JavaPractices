import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter angle in radians: ");
        double radians = scanner.nextDouble();

        double degrees = Math.toDegrees(radians);
        System.out.println("Angle in radians: " + radians);
        System.out.println("Angle in degrees: " + degrees);

        scanner.close();
    }
}
