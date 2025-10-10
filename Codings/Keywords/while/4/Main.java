import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();

        int i = 1;
        while (i <= n) {
            System.out.println("Square of " + i + ": " + i * i);
            i++;
        }
    }
}
  