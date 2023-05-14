import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a binary number: ");
        String binaryInput = scanner.nextLine();

        int decimalValue = binaryToDecimal(binaryInput);
        System.out.println("Decimal equivalent: " + decimalValue);
    }

    private static int binaryToDecimal(String binary) {
        return Integer.parseInt(binary, 2);
    }
}
