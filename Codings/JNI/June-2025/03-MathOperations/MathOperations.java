public class MathOperations {
    // Load the native library
    static {
        try {
            System.loadLibrary("MathOperations");
        } catch (UnsatisfiedLinkError e) {
            System.err.println("Native library 'MathOperations' not found.");
            System.err.println("Please ensure the library is compiled and in the library path.");
            System.exit(1);
        }
    }

    // Native method declarations for mathematical operations
    public native double sqrt(double x);
    public native double pow(double base, double exponent);
    public native double sin(double x);
    public native double cos(double x);
    public native double tan(double x);
    public native double log(double x);
    public native double exp(double x);
    public native double factorial(int n);
    public native double fibonacci(int n);
    public native double[] matrixMultiply(double[] matrix1, double[] matrix2, int rows1, int cols1, int cols2);
    public native double determinant(double[] matrix, int size);
    public native double[] solveLinearSystem(double[] coefficients, double[] constants, int size);
    public native double mean(double[] values);
    public native double variance(double[] values);
    public native double standardDeviation(double[] values);
    public native double correlation(double[] x, double[] y);
    public native double[] sortArray(double[] array);
    public native int gcd(int a, int b);
    public native boolean isPrime(int n);

    public static void main(String[] args) {
        System.out.println("=== JNI Mathematical Operations Demo ===");
        
        MathOperations math = new MathOperations();
        
        // Test 1: Basic mathematical functions
        System.out.println("\n1. Basic Mathematical Functions:");
        double x = 16.0;
        double y = 3.0;
        System.out.printf("sqrt(%.1f) = %.6f\n", x, math.sqrt(x));
        System.out.printf("%.1f^%.1f = %.6f\n", x, y, math.pow(x, y));
        System.out.printf("sin(%.1f) = %.6f\n", x, math.sin(x));
        System.out.printf("cos(%.1f) = %.6f\n", x, math.cos(x));
        System.out.printf("tan(%.1f) = %.6f\n", x, math.tan(x));
        System.out.printf("log(%.1f) = %.6f\n", x, math.log(x));
        System.out.printf("exp(%.1f) = %.6f\n", y, math.exp(y));
        
        // Test 2: Factorial and Fibonacci
        System.out.println("\n2. Factorial and Fibonacci:");
        int n = 10;
        System.out.printf("factorial(%d) = %.0f\n", n, math.factorial(n));
        System.out.printf("fibonacci(%d) = %.0f\n", n, math.fibonacci(n));
        
        // Test 3: Matrix operations
        System.out.println("\n3. Matrix Operations:");
        double[] matrix1 = {1, 2, 3, 4}; // 2x2 matrix
        double[] matrix2 = {5, 6, 7, 8}; // 2x2 matrix
        
        System.out.println("Matrix 1:");
        printMatrix(matrix1, 2, 2);
        System.out.println("Matrix 2:");
        printMatrix(matrix2, 2, 2);
        
        double[] result = math.matrixMultiply(matrix1, matrix2, 2, 2, 2);
        System.out.println("Matrix Multiplication Result:");
        printMatrix(result, 2, 2);
        
        double det = math.determinant(matrix1, 2);
        System.out.printf("Determinant of Matrix 1: %.2f\n", det);
        
        // Test 4: Linear system solving
        System.out.println("\n4. Linear System Solving:");
        double[] coefficients = {2, 1, 1, 3}; // 2x2 coefficient matrix
        double[] constants = {5, 6}; // constants vector
        
        System.out.println("Coefficient Matrix:");
        printMatrix(coefficients, 2, 2);
        System.out.println("Constants: [" + constants[0] + ", " + constants[1] + "]");
        
        double[] solution = math.solveLinearSystem(coefficients, constants, 2);
        System.out.println("Solution: [" + solution[0] + ", " + solution[1] + "]");
        
        // Test 5: Statistical functions
        System.out.println("\n5. Statistical Functions:");
        double[] data = {1.2, 2.3, 3.4, 4.5, 5.6, 6.7, 7.8, 8.9, 9.0, 10.1};
        System.out.println("Data: " + java.util.Arrays.toString(data));
        
        double mean = math.mean(data);
        double variance = math.variance(data);
        double stdDev = math.standardDeviation(data);
        
        System.out.printf("Mean: %.4f\n", mean);
        System.out.printf("Variance: %.4f\n", variance);
        System.out.printf("Standard Deviation: %.4f\n", stdDev);
        
        // Test 6: Correlation
        System.out.println("\n6. Correlation:");
        double[] x_data = {1, 2, 3, 4, 5};
        double[] y_data = {2, 4, 5, 4, 5};
        System.out.println("X: " + java.util.Arrays.toString(x_data));
        System.out.println("Y: " + java.util.Arrays.toString(y_data));
        
        double corr = math.correlation(x_data, y_data);
        System.out.printf("Correlation: %.4f\n", corr);
        
        // Test 7: Array sorting
        System.out.println("\n7. Array Sorting:");
        double[] unsorted = {3.14, 1.41, 2.71, 0.58, 1.73};
        System.out.println("Unsorted: " + java.util.Arrays.toString(unsorted));
        
        double[] sorted = math.sortArray(unsorted);
        System.out.println("Sorted: " + java.util.Arrays.toString(sorted));
        
        // Test 8: Number theory
        System.out.println("\n8. Number Theory:");
        int a = 48, b = 18;
        System.out.printf("GCD(%d, %d) = %d\n", a, b, math.gcd(a, b));
        
        int[] testPrimes = {2, 3, 4, 5, 7, 9, 11, 13, 15, 17};
        System.out.println("Prime number tests:");
        for (int num : testPrimes) {
            System.out.printf("%d is %s\n", num, math.isPrime(num) ? "prime" : "not prime");
        }
        
        // Test 9: Performance comparison with Java Math
        System.out.println("\n9. Performance Comparison with Java Math:");
        long startTime, endTime;
        double result1, result2;
        
        // Test sqrt performance
        startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            result1 = math.sqrt(i);
        }
        endTime = System.nanoTime();
        long nativeTime = endTime - startTime;
        
        startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            result2 = Math.sqrt(i);
        }
        endTime = System.nanoTime();
        long javaTime = endTime - startTime;
        
        System.out.printf("Native sqrt: %d ns, Java sqrt: %d ns\n", nativeTime, javaTime);
        System.out.printf("Native is %.2fx %s\n", 
            (double)Math.max(nativeTime, javaTime) / Math.min(nativeTime, javaTime),
            nativeTime < javaTime ? "faster" : "slower");
        
        System.out.println("\n=== JNI Mathematical Operations Demo Complete ===");
    }
    
    // Helper method to print matrix
    private static void printMatrix(double[] matrix, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            System.out.print("[");
            for (int j = 0; j < cols; j++) {
                System.out.printf("%.2f", matrix[i * cols + j]);
                if (j < cols - 1) System.out.print(", ");
            }
            System.out.println("]");
        }
    }
} 