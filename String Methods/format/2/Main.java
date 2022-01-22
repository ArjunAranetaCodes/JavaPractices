import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a word: ");
        String userInput = scanner.next();

        if ("java".equalsIgnoreCase(userInput)) {
            System.out.println("You entered 'Java' (case-insensitive).");
        } else {
            System.out.println("You did not enter 'Java'.");
        }
    }
}
