import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of terms in Fibonacci series: ");
        int n = scanner.nextInt();

        int firstTerm = 0, secondTerm = 1;

        System.out.print("Fibonacci Series: " + firstTerm + ", " + secondTerm);

        for (int i = 2; i < n; ++i) {
            int nextTerm = firstTerm + secondTerm;
            System.out.print(", " + nextTerm);  

            firstTerm = secondTerm;
            secondTerm = nextTerm;
        }

        System.out.println();
    }
}
