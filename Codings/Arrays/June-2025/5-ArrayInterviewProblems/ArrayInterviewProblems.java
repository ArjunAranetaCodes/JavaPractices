/**
 * Array Interview Problems - Classic Coding Challenges in Java
 * Demonstrates missing number, duplicates, max subarray sum, etc.
 */
import java.util.Arrays;
import java.util.HashSet;

public class ArrayInterviewProblems {
    public static void main(String[] args) {
        System.out.println("=== ARRAY INTERVIEW PROBLEMS TUTORIAL ===\n");

        // 1. Find the Missing Number (1 to n)
        int[] arr1 = {1, 2, 4, 5, 6};
        System.out.println("Array: " + Arrays.toString(arr1));
        System.out.println("Missing number: " + findMissingNumber(arr1, 6));

        // 2. Find Duplicates
        int[] arr2 = {1, 2, 3, 1, 3, 6, 6};
        System.out.println("\nArray: " + Arrays.toString(arr2));
        System.out.print("Duplicates: ");
        printDuplicates(arr2);

        // 3. Maximum Subarray Sum (Kadane's Algorithm)
        int[] arr3 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("\nArray: " + Arrays.toString(arr3));
        System.out.println("Maximum subarray sum: " + maxSubArraySum(arr3));

        // 4. Move Zeros to End
        int[] arr4 = {0, 1, 0, 3, 12};
        System.out.println("\nOriginal array: " + Arrays.toString(arr4));
        moveZerosToEnd(arr4);
        System.out.println("After moving zeros: " + Arrays.toString(arr4));

        // 5. Find Pair with Given Sum
        int[] arr5 = {8, 7, 2, 5, 3, 1};
        int sum = 10;
        System.out.println("\nArray: " + Arrays.toString(arr5));
        System.out.println("Pair with sum " + sum + ": " + Arrays.toString(findPairWithSum(arr5, sum)));

        System.out.println("\n=== END OF ARRAY INTERVIEW PROBLEMS TUTORIAL ===");
    }

    // 1. Find the missing number in 1 to n
    public static int findMissingNumber(int[] arr, int n) {
        int total = n * (n + 1) / 2;
        int sum = 0;
        for (int num : arr) sum += num;
        return total - sum;
    }

    // 2. Print duplicates in array
    public static void printDuplicates(int[] arr) {
        HashSet<Integer> seen = new HashSet<>();
        HashSet<Integer> printed = new HashSet<>();
        for (int num : arr) {
            if (!seen.add(num) && !printed.contains(num)) {
                System.out.print(num + " ");
                printed.add(num);
            }
        }
        System.out.println();
    }

    // 3. Maximum subarray sum (Kadane's Algorithm)
    public static int maxSubArraySum(int[] arr) {
        int maxSoFar = arr[0], maxEndingHere = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    // 4. Move zeros to end
    public static void moveZerosToEnd(int[] arr) {
        int n = arr.length, count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) arr[count++] = arr[i];
        }
        while (count < n) arr[count++] = 0;
    }

    // 5. Find pair with given sum
    public static int[] findPairWithSum(int[] arr, int sum) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(sum - num)) {
                return new int[]{num, sum - num};
            }
            set.add(num);
        }
        return new int[]{};
    }
} 