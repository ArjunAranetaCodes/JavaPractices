/**
 * Tutorial: Array Operations
 * Demonstrates common array operations
 */
public class ArrayOperations {
    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 1, 9, 3};
        
        // Finding maximum
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("Maximum: " + max);
        
        // Finding minimum
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println("Minimum: " + min);
        
        // Sum of elements
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        System.out.println("Sum: " + sum);
        
        // Average
        double average = (double) sum / arr.length;
        System.out.println("Average: " + average);
        
        // Searching for an element
        int searchValue = 8;
        boolean found = false;
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == searchValue) {
                found = true;
                index = i;
                break;
            }
        }
        if (found) {
            System.out.println(searchValue + " found at index " + index);
        } else {
            System.out.println(searchValue + " not found");
        }
        
        // Reversing array
        System.out.println("\nOriginal array:");
        printArray(arr);
        
        int[] reversed = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reversed[i] = arr[arr.length - 1 - i];
        }
        
        System.out.println("Reversed array:");
        printArray(reversed);
    }
    
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}











