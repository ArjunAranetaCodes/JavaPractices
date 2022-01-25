import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String correctUsername = "admin";

        System.out.print("Enter your username: ");
        String enteredUsername = scanner.next();

        if (correctUsername.equalsIgnoreCase(enteredUsername)) {
            System.out.println("Login successful (case-insensitive).");
        } else {
            System.out.println("Incorrect username. Login failed.");
        }
    }
}
