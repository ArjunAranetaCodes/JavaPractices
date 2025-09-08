/**
 * Array Basics - Fundamental Array Operations in Java
 * This program demonstrates the core concepts and operations with arrays
 */
public class ArrayBasics {
    
    public static void main(String[] args) {
        System.out.println("=== ARRAY BASICS TUTORIAL ===\n");
        
        // 1. Array Declaration and Initialization
        System.out.println("1. ARRAY DECLARATION AND INITIALIZATION:");
        System.out.println("----------------------------------------");
        
        // Method 1: Declare and initialize in one line
        int[] numbers = {10, 20, 30, 40, 50};
        System.out.println("Array initialized: " + java.util.Arrays.toString(numbers));
        
        // Method 2: Declare first, then initialize
        int[] scores = new int[5];
        scores[0] = 85;
        scores[1] = 92;
        scores[2] = 78;
        scores[3] = 96;
        scores[4] = 88;
        System.out.println("Scores array: " + java.util.Arrays.toString(scores));
        
        // Method 3: Using array literal with new
        String[] fruits = new String[]{"Apple", "Banana", "Orange", "Mango"};
        System.out.println("Fruits array: " + java.util.Arrays.toString(fruits));
        
        // 2. Accessing Array Elements
        System.out.println("\n2. ACCESSING ARRAY ELEMENTS:");
        System.out.println("----------------------------");
        System.out.println("First element of numbers: " + numbers[0]);
        System.out.println("Last element of numbers: " + numbers[numbers.length - 1]);
        System.out.println("Middle element of fruits: " + fruits[fruits.length / 2]);
        
        // 3. Array Length
        System.out.println("\n3. ARRAY LENGTH:");
        System.out.println("----------------");
        System.out.println("Length of numbers array: " + numbers.length);
        System.out.println("Length of fruits array: " + fruits.length);
        
        // 4. Iterating Through Arrays
        System.out.println("\n4. ITERATING THROUGH ARRAYS:");
        System.out.println("---------------------------");
        
        // Using for loop
        System.out.println("Using traditional for loop:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("numbers[" + i + "] = " + numbers[i]);
        }
        
        // Using enhanced for loop (for-each)
        System.out.println("\nUsing enhanced for loop:");
        for (int score : scores) {
            System.out.println("Score: " + score);
        }
        
        // Using forEach with streams
        System.out.println("\nUsing streams forEach:");
        java.util.Arrays.stream(fruits).forEach(fruit -> System.out.println("Fruit: " + fruit));
        
        // 5. Array Operations
        System.out.println("\n5. ARRAY OPERATIONS:");
        System.out.println("--------------------");
        
        // Finding sum and average
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        double average = (double) sum / scores.length;
        System.out.println("Sum of scores: " + sum);
        System.out.println("Average score: " + average);
        
        // Finding maximum and minimum
        int max = scores[0];
        int min = scores[0];
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > max) max = scores[i];
            if (scores[i] < min) min = scores[i];
        }
        System.out.println("Maximum score: " + max);
        System.out.println("Minimum score: " + min);
        
        // 6. Array Copying
        System.out.println("\n6. ARRAY COPYING:");
        System.out.println("-----------------");
        
        // Method 1: Using System.arraycopy
        int[] original = {1, 2, 3, 4, 5};
        int[] copy1 = new int[original.length];
        System.arraycopy(original, 0, copy1, 0, original.length);
        System.out.println("Original: " + java.util.Arrays.toString(original));
        System.out.println("Copy (System.arraycopy): " + java.util.Arrays.toString(copy1));
        
        // Method 2: Using Arrays.copyOf
        int[] copy2 = java.util.Arrays.copyOf(original, original.length);
        System.out.println("Copy (Arrays.copyOf): " + java.util.Arrays.toString(copy2));
        
        // Method 3: Using clone method
        int[] copy3 = original.clone();
        System.out.println("Copy (clone): " + java.util.Arrays.toString(copy3));
        
        // 7. Array Sorting
        System.out.println("\n7. ARRAY SORTING:");
        System.out.println("-----------------");
        
        int[] unsorted = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Unsorted array: " + java.util.Arrays.toString(unsorted));
        
        // Using Arrays.sort
        java.util.Arrays.sort(unsorted);
        System.out.println("Sorted array: " + java.util.Arrays.toString(unsorted));
        
        // 8. Searching in Arrays
        System.out.println("\n8. SEARCHING IN ARRAYS:");
        System.out.println("----------------------");
        
        int searchValue = 25;
        int index = java.util.Arrays.binarySearch(unsorted, searchValue);
        if (index >= 0) {
            System.out.println(searchValue + " found at index: " + index);
        } else {
            System.out.println(searchValue + " not found in array");
        }
        
        // Linear search
        int linearIndex = linearSearch(unsorted, 22);
        System.out.println("Linear search for 22: " + linearIndex);
        
        // 9. Multi-dimensional Arrays
        System.out.println("\n9. MULTI-DIMENSIONAL ARRAYS:");
        System.out.println("----------------------------");
        
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        System.out.println("2D Array (Matrix):");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        
        // 10. Common Array Methods
        System.out.println("\n10. COMMON ARRAY METHODS:");
        System.out.println("-------------------------");
        
        int[] testArray = {5, 2, 8, 1, 9, 3};
        System.out.println("Original array: " + java.util.Arrays.toString(testArray));
        
        // Fill array
        java.util.Arrays.fill(testArray, 0);
        System.out.println("After fill with 0: " + java.util.Arrays.toString(testArray));
        
        // Reset array
        testArray = new int[]{5, 2, 8, 1, 9, 3};
        
        // Check if arrays are equal
        int[] array1 = {1, 2, 3};
        int[] array2 = {1, 2, 3};
        boolean areEqual = java.util.Arrays.equals(array1, array2);
        System.out.println("Arrays are equal: " + areEqual);
        
        System.out.println("\n=== END OF ARRAY BASICS TUTORIAL ===");
    }
    
    /**
     * Linear search method to find an element in an array
     * @param arr the array to search in
     * @param target the value to find
     * @return index of the target if found, -1 if not found
     */
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
} 