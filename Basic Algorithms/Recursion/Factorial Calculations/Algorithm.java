public class Algorithm {

    public static void main(String[] args) {
        // Test the factorial calculation
        int n = 5;
        long result = calculateFactorial(n);
        System.out.println("Factorial of " + n + " is: " + result);
    }

    // Recursive method to calculate factorial
    public static long calculateFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * calculateFactorial(n - 1);
        }
    }
}
