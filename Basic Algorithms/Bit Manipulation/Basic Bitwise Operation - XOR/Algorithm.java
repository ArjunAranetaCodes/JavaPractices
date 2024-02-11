public class Algorithm {
    public static void main(String[] args) {
        // Example usage of XOR bitwise operation
        int num1 = 12;  // Binary: 1100
        int num2 = 7;   // Binary: 0111

        // XOR operation
        int result = xorOperation(num1, num2);

        // Display the result
        System.out.println("Result of XOR: " + result);
    }

    // Method to perform XOR operation
    private static int xorOperation(int a, int b) {
        return a ^ b;
    }
}
