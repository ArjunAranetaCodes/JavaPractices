/**
 * Tutorial: Array Utilities
 * Demonstrates useful array operations using Arrays class
 */
import java.util.Arrays;

public class ArrayUtils {
    public static void main(String[] args) {
        int[] arr1 = {5, 2, 8, 1, 9};
        int[] arr2 = {5, 2, 8, 1, 9};
        int[] arr3 = {1, 2, 3, 4, 5};
        
        // toString() - convert array to string
        System.out.println("Array: " + Arrays.toString(arr1));
        
        // equals() - compare arrays
        System.out.println("arr1 equals arr2: " + Arrays.equals(arr1, arr2));
        System.out.println("arr1 equals arr3: " + Arrays.equals(arr1, arr3));
        
        // fill() - fill array with value
        int[] filled = new int[5];
        Arrays.fill(filled, 10);
        System.out.println("Filled array: " + Arrays.toString(filled));
        
        // copyOf() - copy array
        int[] copied = Arrays.copyOf(arr1, arr1.length);
        System.out.println("Copied array: " + Arrays.toString(copied));
        
        // copyOfRange() - copy range of array
        int[] range = Arrays.copyOfRange(arr1, 1, 4);
        System.out.println("Range copy: " + Arrays.toString(range));
        
        // binarySearch() - search in sorted array
        Arrays.sort(arr1);
        int index = Arrays.binarySearch(arr1, 8);
        System.out.println("Index of 8: " + index);
        
        // asList() - convert array to list
        String[] names = {"Alice", "Bob", "Charlie"};
        System.out.println("List: " + Arrays.asList(names));
    }
}













