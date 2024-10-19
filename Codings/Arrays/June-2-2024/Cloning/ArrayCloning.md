## Problem: 
Cloning an Array of Integers

## Description: 
Create a program that demonstrates the cloning of a single-dimensional array of integers.

## Input:

Original array: [1, 2, 3, 4, 5]

## Output:

Cloned array: [1, 2, 3, 4, 5]

## Code Answer:
```Java
public class ArrayCloning {
    public static void main(String[] args) {
        int[] original = {1, 2, 3, 4, 5};
        int[] cloned = original.clone();

        System.out.println("Original array: " + Arrays.toString(original));
        System.out.println("Cloned array: " + Arrays.toString(cloned));
    }
}
```

File Name: ArrayCloning.java

This program demonstrates the cloning of a single-dimensional array of integers using the clone() method. The original array is cloned into the cloned array, and both arrays are printed to the console to show that they have the same contents.

Note: The clone() method creates a shallow copy of the array, meaning that it only copies the references to the elements, not the elements themselves. This means that both arrays share the same elements, and modifying one array will affect the other. If you need a deep copy of the array, you can use the Arrays.copyOf() method instead.