public class Algorithm {
    // Function to solve the 0/1 Knapsack problem
    static int knapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
            }
        }

        return dp[n][capacity];
    }

    public static void main(String[] args) {
        // Example usage
        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 4, 5, 6};
        int capacity = 5;

        int maxValue = knapsack(weights, values, capacity);

        System.out.println("Maximum value in knapsack: " + maxValue);
    }
}
