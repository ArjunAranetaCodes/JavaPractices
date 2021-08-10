import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        double input = scanner.nextDouble();
        double ceilValue = Math.ceil(input);
        System.out.println("Ceil value of " + input + " is: " + ceilValue);
    }
}
  