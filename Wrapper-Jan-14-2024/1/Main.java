import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int num = scanner.nextInt();

        int digitSum = calculateDigitSum(num);
        System.out.println("Sum of digits: " + digitSum);
    }

    private static int calculateDigitSum(int number) {
        int sum = 0;
        String numStr = Integer.toString(number);

        for (int i = 0; i < numStr.length(); i++) {
            char digitChar = numStr.charAt(i);
            int digit = Character.getNumericValue(digitChar);
            sum += digit;
        }

        return sum;
    }
}
