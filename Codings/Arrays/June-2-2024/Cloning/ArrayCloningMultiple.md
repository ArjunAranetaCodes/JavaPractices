## Problem: 
Cloning a 2D Array of Integers

## Description: 
Create a program that demonstrates the cloning of a multidimensional array (2D array) of integers.

## Input:

Original array: [[1, 2], [3, 4], [5, 6]]

## Output:

Cloned array: [[1, 2], [3, 4], [5, 6]]

## Code Answer:
```Java
import java.util.Arrays;

public class ArrayCloning {
    public static void main(String[] args) {
        int[][] original = {{1, 2}, {3, 4}, {5, 6}};
        int[][] cloned = Arrays.copyOf(original, original.length);

        for (int i = 0; i < cloned.length; i++) {
            cloned[i] = Arrays.copyOf(original[i], original[i].length);
        }

        System.out.println("Original array: " + Arrays.deepToString(original));
        System.out.println("Cloned array: " + Arrays.deepToString(cloned));
    }
}
```

File Name: ArrayCloning.java

This program demonstrates the cloning of a multidimensional array (2D array) of integers using the Arrays.copyOf() method. The original array is cloned into the cloned array, and both arrays are printed to the console using Arrays.deepToString() to show that they have the same contents.

Note: When cloning a multidimensional array, you need to use a combination of Arrays.copyOf() and a loop to clone each sub-array separately, as shown in the example. This is because Arrays.copyOf() only clones the top-level array, and not the sub-arrays.