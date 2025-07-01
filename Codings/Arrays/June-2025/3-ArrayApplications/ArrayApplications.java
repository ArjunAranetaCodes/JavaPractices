/**
 * Array Applications - Practical Array Operations in Java
 * Demonstrates frequency count, reverse, merge, and more
 */
import java.util.Arrays;
import java.util.HashMap;

public class ArrayApplications {
    public static void main(String[] args) {
        System.out.println("=== ARRAY APPLICATIONS TUTORIAL ===\n");

        // 1. Frequency Count
        int[] freqArr = {1, 2, 2, 3, 4, 4, 4, 5};
        System.out.println("Array: " + Arrays.toString(freqArr));
        System.out.println("Frequency count:");
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : freqArr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        for (int key : freqMap.keySet()) {
            System.out.println(key + ": " + freqMap.get(key));
        }

        // 2. Reverse Array
        int[] revArr = {10, 20, 30, 40, 50};
        System.out.println("\nOriginal array: " + Arrays.toString(revArr));
        reverse(revArr);
        System.out.println("Reversed array: " + Arrays.toString(revArr));

        // 3. Merge Two Sorted Arrays
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8};
        int[] merged = mergeSortedArrays(arr1, arr2);
        System.out.println("\nMerged sorted arrays: " + Arrays.toString(merged));

        // 4. Remove Even Numbers
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println("\nOriginal array: " + Arrays.toString(arr));
        int[] odds = removeEvenNumbers(arr);
        System.out.println("Array with even numbers removed: " + Arrays.toString(odds));

        // 5. Find All Unique Elements
        int[] dupArr = {1, 2, 2, 3, 4, 4, 5};
        System.out.println("\nOriginal array: " + Arrays.toString(dupArr));
        System.out.print("Unique elements: ");
        printUniqueElements(dupArr);

        System.out.println("\n=== END OF ARRAY APPLICATIONS TUTORIAL ===");
    }

    // Reverse an array in place
    public static void reverse(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    // Merge two sorted arrays
    public static int[] mergeSortedArrays(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                result[k++] = a[i++];
            } else {
                result[k++] = b[j++];
            }
        }
        while (i < a.length) result[k++] = a[i++];
        while (j < b.length) result[k++] = b[j++];
        return result;
    }

    // Remove even numbers from array
    public static int[] removeEvenNumbers(int[] arr) {
        return Arrays.stream(arr).filter(x -> x % 2 != 0).toArray();
    }

    // Print unique elements
    public static void printUniqueElements(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) map.put(num, map.getOrDefault(num, 0) + 1);
        for (int key : map.keySet()) {
            if (map.get(key) == 1) System.out.print(key + " ");
        }
        System.out.println();
    }
} 