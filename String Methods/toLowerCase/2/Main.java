import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String userInput = scanner.nextLine();
        String lowerCaseInput = userInput.toLowerCase();

        System.out.println("Original Input: " + userInput);
        System.out.println("Lowercase Input: " + lowerCaseInput);

        scanner.close();
    }
}
 