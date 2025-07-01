# Multi-Dimensional Arrays Tutorial

## Overview
This tutorial demonstrates common operations on multi-dimensional arrays (matrices) in Java, including sum, transpose, multiplication, and identity matrix check.

## What You'll Learn
- How to add two matrices
- How to transpose a matrix
- How to multiply two matrices
- How to check for an identity matrix

## Key Concepts & Code Examples

### 1. Matrix Addition
Add two matrices element-wise:
```java
public static int[][] addMatrices(int[][] a, int[][] b) {
    int rows = a.length, cols = a[0].length;
    int[][] result = new int[rows][cols];
    for (int i = 0; i < rows; i++)
        for (int j = 0; j < cols; j++)
            result[i][j] = a[i][j] + b[i][j];
    return result;
}
```

### 2. Matrix Transpose
Swap rows and columns:
```java
public static int[][] transpose(int[][] matrix) {
    int rows = matrix.length, cols = matrix[0].length;
    int[][] transposed = new int[cols][rows];
    for (int i = 0; i < rows; i++)
        for (int j = 0; j < cols; j++)
            transposed[j][i] = matrix[i][j];
    return transposed;
}
```

### 3. Matrix Multiplication
Multiply two matrices:
```java
public static int[][] multiplyMatrices(int[][] a, int[][] b) {
    int rows = a.length, cols = b[0].length, n = a[0].length;
    int[][] result = new int[rows][cols];
    for (int i = 0; i < rows; i++)
        for (int j = 0; j < cols; j++)
            for (int k = 0; k < n; k++)
                result[i][j] += a[i][k] * b[k][j];
    return result;
}
```

### 4. Identity Matrix Check
Check if a matrix is an identity matrix:
```java
public static boolean isIdentityMatrix(int[][] matrix) {
    int n = matrix.length;
    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++) {
            if (i == j && matrix[i][j] != 1) return false;
            if (i != j && matrix[i][j] != 0) return false;
        }
    return true;
}
```

### 5. Print a Matrix
Print a matrix row by row:
```java
public static void printMatrix(int[][] matrix) {
    for (int[] row : matrix) {
        System.out.println(Arrays.toString(row));
    }
}
```

## Running the Program
1. Compile:
   ```bash
   javac MultiDimensionalArrays.java
   ```
2. Run:
   ```bash
   java MultiDimensionalArrays
   ```

## Practice Exercises
- Find the trace (sum of diagonal elements) of a matrix
- Check if a matrix is symmetric
- Rotate a matrix by 90 degrees

## Additional Resources
- [Java 2D Arrays Documentation](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/multidimarrays.html) 