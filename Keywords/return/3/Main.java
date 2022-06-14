public class Main {
    public static void main(String[] args) {
        int factorial = calculateFactorial(5);
        System.out.println("Factorial: " + factorial);
    }

    static int calculateFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * calculateFactorial(n - 1);
        }
    }
}
