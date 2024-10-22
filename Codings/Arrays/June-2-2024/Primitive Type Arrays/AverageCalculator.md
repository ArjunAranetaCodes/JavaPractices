## Problem: 
Calculating the Average of an Array of Integers

## Description: 
Create a program that demonstrates the use of primitive type arrays to calculate the average of an array of integers.

## Input:

Integer array: {1, 2, 3, 4, 5}

## Output:

Average: 3.0

## Code Answer:
```Java
public class AverageCalculator {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        double average = calculateAverage(numbers);
        System.out.println("Average: " + average);
    }

    public static double calculateAverage(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return (double) sum / numbers.length;
    }
}
```

File Name: AverageCalculator.java

This program demonstrates the use of primitive type arrays to calculate the average of an array of integers. The AverageCalculator class uses an int array to store the numbers, and a calculateAverage method to calculate the average.

Note: Primitive type arrays are used to store and manipulate primitive data types like int, double, etc. This is useful for creating arrays of numbers, characters, and other primitive data types.