/**
 * Multi-Dimensional Arrays - Matrix Operations in Java
 * Demonstrates sum, transpose, multiplication, and more
 */
import java.util.Arrays;

public class MultiDimensionalArrays {
    public static void main(String[] args) {
        System.out.println("=== MULTI-DIMENSIONAL ARRAYS TUTORIAL ===\n");

        // 1. Matrix Sum
        int[][] matA = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int[][] matB = {
            {9, 8, 7},
            {6, 5, 4},
            {3, 2, 1}
        };
        int[][] sum = addMatrices(matA, matB);
        System.out.println("Matrix A:");
        printMatrix(matA);
        System.out.println("Matrix B:");
        printMatrix(matB);
        System.out.println("Sum of matrices:");
        printMatrix(sum);

        // 2. Matrix Transpose
        int[][] transposed = transpose(matA);
        System.out.println("\nTranspose of Matrix A:");
        printMatrix(transposed);

        // 3. Matrix Multiplication
        int[][] product = multiplyMatrices(matA, matB);
        System.out.println("\nProduct of matrices:");
        printMatrix(product);

        // 4. Identity Matrix Check
        int[][] identity = {
            {1, 0, 0},
            {0, 1, 0},
            {0, 0, 1}
        };
        System.out.println("\nIs identity matrix: " + isIdentityMatrix(identity));
        System.out.println("Is identity matrix: " + isIdentityMatrix(matA));

        System.out.println("\n=== END OF MULTI-DIMENSIONAL ARRAYS TUTORIAL ===");
    }

    // Add two matrices
    public static int[][] addMatrices(int[][] a, int[][] b) {
        int rows = a.length, cols = a[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                result[i][j] = a[i][j] + b[i][j];
        return result;
    }

    // Transpose a matrix
    public static int[][] transpose(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int[][] transposed = new int[cols][rows];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                transposed[j][i] = matrix[i][j];
        return transposed;
    }

    // Multiply two matrices
    public static int[][] multiplyMatrices(int[][] a, int[][] b) {
        int rows = a.length, cols = b[0].length, n = a[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                for (int k = 0; k < n; k++)
                    result[i][j] += a[i][k] * b[k][j];
        return result;
    }

    // Check if a matrix is an identity matrix
    public static boolean isIdentityMatrix(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                if (i == j && matrix[i][j] != 1) return false;
                if (i != j && matrix[i][j] != 0) return false;
            }
        return true;
    }

    // Print a matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
} 