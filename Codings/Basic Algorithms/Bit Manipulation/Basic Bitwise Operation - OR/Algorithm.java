public class Algorithm {
    public static void main(String[] args) {
        // Two integers to perform bitwise OR
        int num1 = 10; // Binary: 1010
        int num2 = 5;  // Binary: 0101

        // Perform bitwise OR operation
        int result = num1 | num2;

        // Display results
        System.out.println("Number 1: " + num1 + " (Binary: " + Integer.toBinaryString(num1) + ")");
        System.out.println("Number 2: " + num2 + " (Binary: " + Integer.toBinaryString(num2) + ")");
        System.out.println("Result of Bitwise OR: " + result + " (Binary: " + Integer.toBinaryString(result) + ")");
    }
}
