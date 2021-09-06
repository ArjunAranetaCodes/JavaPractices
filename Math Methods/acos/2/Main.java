import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an angle in radians: ");
        double angle = scanner.nextDouble();
        double result = Math.acos(angle);
        System.out.println("The arccosine of " + angle + " is: " + result);
    }
}
  