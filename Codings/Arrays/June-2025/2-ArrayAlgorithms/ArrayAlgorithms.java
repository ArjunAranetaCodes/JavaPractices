/**
 * Array Algorithms - Sorting and Searching Algorithms in Java
 * This program demonstrates various algorithms for sorting and searching arrays
 */
import java.util.Arrays;
import java.util.Random;

public class ArrayAlgorithms {
    
    public static void main(String[] args) {
        System.out.println("=== ARRAY ALGORITHMS TUTORIAL ===\n");
        
        // Test arrays
        int[] arr1 = {64, 34, 25, 12, 22, 11, 90};
        int[] arr2 = {5, 2, 4, 6, 1, 3};
        int[] arr3 = {38, 27, 43, 3, 9, 82, 10};
        
        System.out.println("Original Arrays:");
        System.out.println("Array 1: " + Arrays.toString(arr1));
        System.out.println("Array 2: " + Arrays.toString(arr2));
        System.out.println("Array 3: " + Arrays.toString(arr3));
        
        // 1. Bubble Sort
        System.out.println("\n1. BUBBLE SORT:");
        System.out.println("---------------");
        int[] bubbleArray = arr1.clone();
        System.out.println("Before: " + Arrays.toString(bubbleArray));
        bubbleSort(bubbleArray);
        System.out.println("After:  " + Arrays.toString(bubbleArray));
        
        // 2. Selection Sort
        System.out.println("\n2. SELECTION SORT:");
        System.out.println("------------------");
        int[] selectionArray = arr2.clone();
        System.out.println("Before: " + Arrays.toString(selectionArray));
        selectionSort(selectionArray);
        System.out.println("After:  " + Arrays.toString(selectionArray));
        
        // 3. Insertion Sort
        System.out.println("\n3. INSERTION SORT:");
        System.out.println("------------------");
        int[] insertionArray = arr3.clone();
        System.out.println("Before: " + Arrays.toString(insertionArray));
        insertionSort(insertionArray);
        System.out.println("After:  " + Arrays.toString(insertionArray));
        
        // 4. Merge Sort
        System.out.println("\n4. MERGE SORT:");
        System.out.println("--------------");
        int[] mergeArray = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Before: " + Arrays.toString(mergeArray));
        mergeSort(mergeArray, 0, mergeArray.length - 1);
        System.out.println("After:  " + Arrays.toString(mergeArray));
        
        // 5. Quick Sort
        System.out.println("\n5. QUICK SORT:");
        System.out.println("--------------");
        int[] quickArray = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Before: " + Arrays.toString(quickArray));
        quickSort(quickArray, 0, quickArray.length - 1);
        System.out.println("After:  " + Arrays.toString(quickArray));
        
        // 6. Binary Search
        System.out.println("\n6. BINARY SEARCH:");
        System.out.println("-----------------");
        int[] searchArray = {11, 12, 22, 25, 34, 64, 90};
        System.out.println("Sorted array: " + Arrays.toString(searchArray));
        
        int[] searchTargets = {25, 90, 15, 64};
        for (int target : searchTargets) {
            int result = binarySearch(searchArray, target);
            if (result != -1) {
                System.out.println(target + " found at index: " + result);
            } else {
                System.out.println(target + " not found in array");
            }
        }
        
        // 7. Linear Search
        System.out.println("\n7. LINEAR SEARCH:");
        System.out.println("-----------------");
        int[] linearArray = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Array: " + Arrays.toString(linearArray));
        
        int[] linearTargets = {25, 90, 15, 64};
        for (int target : linearTargets) {
            int result = linearSearch(linearArray, target);
            if (result != -1) {
                System.out.println(target + " found at index: " + result);
            } else {
                System.out.println(target + " not found in array");
            }
        }
        
        // 8. Performance Comparison
        System.out.println("\n8. PERFORMANCE COMPARISON:");
        System.out.println("-------------------------");
        performanceComparison();
        
        // 9. Advanced Array Operations
        System.out.println("\n9. ADVANCED ARRAY OPERATIONS:");
        System.out.println("-----------------------------");
        
        // Find second largest
        int[] testArray = {12, 35, 1, 10, 34, 1};
        System.out.println("Array: " + Arrays.toString(testArray));
        System.out.println("Second largest: " + findSecondLargest(testArray));
        
        // Remove duplicates
        int[] duplicateArray = {1, 2, 2, 3, 4, 4, 5, 5};
        System.out.println("Array with duplicates: " + Arrays.toString(duplicateArray));
        int[] uniqueArray = removeDuplicates(duplicateArray);
        System.out.println("After removing duplicates: " + Arrays.toString(uniqueArray));
        
        // Rotate array
        int[] rotateArray = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("Original array: " + Arrays.toString(rotateArray));
        rotateArray(rotateArray, 3);
        System.out.println("After rotating by 3: " + Arrays.toString(rotateArray));
        
        // 10. Two Pointers Technique
        System.out.println("\n10. TWO POINTERS TECHNIQUE:");
        System.out.println("---------------------------");
        
        // Find pair with given sum
        int[] sumArray = {1, 4, 45, 6, 10, -8};
        int targetSum = 16;
        System.out.println("Array: " + Arrays.toString(sumArray));
        System.out.println("Target sum: " + targetSum);
        int[] pair = findPairWithSum(sumArray, targetSum);
        if (pair != null) {
            System.out.println("Pair found: " + pair[0] + " + " + pair[1] + " = " + targetSum);
        } else {
            System.out.println("No pair found with sum " + targetSum);
        }
        
        System.out.println("\n=== END OF ARRAY ALGORITHMS TUTORIAL ===");
    }
    
    // Bubble Sort - O(n²)
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    
    // Selection Sort - O(n²)
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap elements
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
    
    // Insertion Sort - O(n²)
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
    
    // Merge Sort - O(n log n)
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            
            merge(arr, left, mid, right);
        }
    }
    
    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];
        
        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[mid + 1 + j];
        }
        
        int i = 0, j = 0, k = left;
        
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }
        
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
    
    // Quick Sort - O(n log n) average, O(n²) worst case
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        
        return i + 1;
    }
    
    // Binary Search - O(log n)
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                return mid;
            }
            
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1;
    }
    
    // Linear Search - O(n)
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
    
    // Performance comparison
    public static void performanceComparison() {
        Random random = new Random();
        int[] sizes = {100, 1000, 10000};
        
        for (int size : sizes) {
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = random.nextInt(10000);
            }
            
            System.out.println("Array size: " + size);
            
            // Test bubble sort (only for small arrays)
            if (size <= 1000) {
                int[] bubbleArr = arr.clone();
                long startTime = System.nanoTime();
                bubbleSort(bubbleArr);
                long endTime = System.nanoTime();
                System.out.println("Bubble Sort: " + (endTime - startTime) / 1000000 + " ms");
            }
            
            // Test quick sort
            int[] quickArr = arr.clone();
            long startTime = System.nanoTime();
            quickSort(quickArr, 0, quickArr.length - 1);
            long endTime = System.nanoTime();
            System.out.println("Quick Sort: " + (endTime - startTime) / 1000000 + " ms");
            
            // Test built-in sort
            int[] builtinArr = arr.clone();
            startTime = System.nanoTime();
            Arrays.sort(builtinArr);
            endTime = System.nanoTime();
            System.out.println("Built-in Sort: " + (endTime - startTime) / 1000000 + " ms");
            System.out.println();
        }
    }
    
    // Find second largest element
    public static int findSecondLargest(int[] arr) {
        if (arr.length < 2) {
            return -1;
        }
        
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        
        for (int num : arr) {
            if (num > first) {
                second = first;
                first = num;
            } else if (num > second && num != first) {
                second = num;
            }
        }
        
        return second == Integer.MIN_VALUE ? -1 : second;
    }
    
    // Remove duplicates from sorted array
    public static int[] removeDuplicates(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        
        int writeIndex = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                arr[writeIndex] = arr[i];
                writeIndex++;
            }
        }
        
        return Arrays.copyOf(arr, writeIndex);
    }
    
    // Rotate array by k positions
    public static void rotateArray(int[] arr, int k) {
        int n = arr.length;
        k = k % n; // Handle cases where k > n
        
        reverse(arr, 0, n - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);
    }
    
    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    
    // Find pair with given sum using two pointers
    public static int[] findPairWithSum(int[] arr, int target) {
        Arrays.sort(arr); // Sort array first
        
        int left = 0;
        int right = arr.length - 1;
        
        while (left < right) {
            int sum = arr[left] + arr[right];
            
            if (sum == target) {
                return new int[]{arr[left], arr[right]};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        
        return null;
    }
} 