import java.util.Scanner;

public class Algorithm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first integer: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter the second integer: ");
        int num2 = scanner.nextInt();

        // Perform bitwise AND operation
        int result = num1 & num2;

        // Display the result
        System.out.println("Result of bitwise AND: " + result);

        // Close the scanner
        scanner.close();
    }
}
