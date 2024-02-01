public class Algorithm {

    // Function to calculate Fibonacci using dynamic programming
    public static int fibonacci(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        // Test the algorithm with a sample input
        int n = 10;
        int result = fibonacci(n);

        System.out.println("Fibonacci of " + n + " is: " + result);
    }
}
