import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        do {
            System.out.print("Enter a number (0 to exit): ");
            int num = scanner.nextInt();
            count++;
        } while (count < 3);
        scanner.close();
    }
}
