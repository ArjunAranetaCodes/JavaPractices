public class Main {
    public static void main(String[] args) {
        int n = 5; // Change the value for a different factorial
        int factorial = 1;
        int i = 1;
        do {
            factorial *= i;
            i++;
        } while (i <= n);
        System.out.println("Factorial of " + n + ": " + factorial);
    }
}
