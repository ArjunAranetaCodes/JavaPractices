/**
 * Tutorial: Array Sorting
 * Demonstrates sorting arrays using different methods
 */
import java.util.Arrays;

public class ArraySorting {
    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 1, 9, 3};
        
        System.out.println("Original array:");
        printArray(arr);
        
        // Using Arrays.sort() - Quick sort
        int[] arr1 = arr.clone();
        Arrays.sort(arr1);
        System.out.println("\nSorted using Arrays.sort():");
        printArray(arr1);
        
        // Bubble sort
        int[] arr2 = arr.clone();
        bubbleSort(arr2);
        System.out.println("\nSorted using Bubble Sort:");
        printArray(arr2);
        
        // Selection sort
        int[] arr3 = arr.clone();
        selectionSort(arr3);
        System.out.println("\nSorted using Selection Sort:");
        printArray(arr3);
        
        // Insertion sort
        int[] arr4 = arr.clone();
        insertionSort(arr4);
        System.out.println("\nSorted using Insertion Sort:");
        printArray(arr4);
    }
    
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
    
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
    
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}














