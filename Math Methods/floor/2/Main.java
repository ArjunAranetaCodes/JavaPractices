import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a decimal number: ");
        double userInput = scanner.nextDouble();

        double floorValue = Math.floor(userInput);

        System.out.println("Entered Number: " + userInput);
        System.out.println("Floor Value: " + floorValue);
    }
}
