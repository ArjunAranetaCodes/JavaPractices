import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a float number: ");
        float userInput = scanner.nextFloat();

        System.out.println("You entered: " + userInput);

        scanner.close();
    }
}
