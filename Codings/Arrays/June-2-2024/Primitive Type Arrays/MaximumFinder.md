## Problem: 
Finding the Maximum Value in an Array of Doubles

## Description: 
Create a program that demonstrates the use of primitive type arrays to find the maximum value in an array of doubles.

## Input:

Double array: {1.2, 3.4, 5.6, 7.8, 9.0}

## Output:

Maximum value: 9.0

## Code Answer:
```Java
public class MaximumFinder {
    public static void main(String[] args) {
        double[] numbers = {1.2, 3.4, 5.6, 7.8, 9.0};
        double max = findMaximum(numbers);
        System.out.println("Maximum value: " + max);
    }

    public static double findMaximum(double[] numbers) {
        double max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }
}
```

File Name: MaximumFinder.java

This program demonstrates the use of primitive type arrays to find the maximum value in an array of doubles. The MaximumFinder class uses a double array to store the numbers, and a findMaximum method to find the maximum value.

Note: Primitive type arrays are used to store and manipulate primitive data types like double, int, etc. This is useful for creating arrays of numbers, characters, and other primitive data types.