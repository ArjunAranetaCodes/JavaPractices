import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int num = scanner.nextInt();

        int reversedNum = reverseNumber(num);
        System.out.println("Reversed number: " + reversedNum);
    }

    private static int reverseNumber(int number) {
        String numStr = Integer.toString(number);
        StringBuilder reversedStr = new StringBuilder(numStr).reverse();
        return Integer.parseInt(reversedStr.toString());
    }
}
