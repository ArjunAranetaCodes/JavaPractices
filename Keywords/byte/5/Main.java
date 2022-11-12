import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a byte value: ");
        byte userInput = scanner.nextByte();

        System.out.println("User entered byte value: " + userInput);
    }
}
