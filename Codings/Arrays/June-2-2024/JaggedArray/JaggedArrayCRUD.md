## Problem: 
Perform CRUD operations on a jagged array of integers

## Description: 
Create a program that demonstrates the CRUD operations for a jagged array of integers

## Input:

Create: [[1, 2], [3, 4, 5], [6, 7, 8, 9]]

Read: Print the entire array

Update: Update the second sub-array to [10, 11, 12]

Delete: Delete the third sub-array

## Output:

After Create: [[1, 2], [3, 4, 5], [6, 7, 8, 9]]

After Read: [[1, 2], [3, 4, 5], [6, 7, 8, 9]]

After Update: [[1, 2], [10, 11, 12], [6, 7, 8, 9]]

After Delete: [[1, 2], [10, 11, 12]]

## Code Answer:
```Java
public class JaggedArrayCRUD {
    public static void main(String[] args) {
        // Create
        int[][] jaggedArray = {{1, 2}, {3, 4, 5}, {6, 7, 8, 9}};

        // Read
        System.out.println("After Create: " + Arrays.deepToString(jaggedArray));

        // Update
        jaggedArray[1] = new int[]{10, 11, 12};
        System.out.println("After Update: " + Arrays.deepToString(jaggedArray));

        // Delete
        jaggedArray = Arrays.copyOf(jaggedArray, jaggedArray.length - 1);
        System.out.println("After Delete: " + Arrays.deepToString(jaggedArray));
    }
}
```

File Name: JaggedArrayCRUD.java

This program demonstrates the CRUD operations for a jagged array of integers. The Create operation initializes the jagged array, the Read operation prints the entire array, the Update operation updates the second sub-array, and the Delete operation deletes the third sub-array.

Note: The Arrays.copyOf() method is used to create a new copy of the array with the updated length, and the Arrays.deepToString() method is used to print the jagged array.