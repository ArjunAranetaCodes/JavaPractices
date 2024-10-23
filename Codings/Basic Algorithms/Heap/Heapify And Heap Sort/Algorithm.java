public class Algorithm {
    public static void main(String[] args) {
        int[] array = {4, 10, 3, 5, 1};
        
        System.out.println("Original Array:");
        printArray(array);

        // Heapify the array
        heapify(array);

        System.out.println("\nHeapified Array:");
        printArray(array);

        // Perform Heap Sort
        heapSort(array);

        System.out.println("\nSorted Array:");
        printArray(array);
    }

    // Helper method to print an array
    private static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    // Method to heapify an array
    private static void heapify(int[] arr) {
        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapifyUtil(arr, n, i);
        }
    }

    // Utility method for heapify
    private static void heapifyUtil(int[] arr, int n, int i) {
        int largest = i;  // Initialize largest as root
        int left = 2 * i + 1;  // Left child
        int right = 2 * i + 2;  // Right child

        // If left child is larger than root
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            // Swap arr[i] and arr[largest]
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // Recursively heapify the affected sub-tree
            heapifyUtil(arr, n, largest);
        }
    }

    // Method to perform Heap Sort
    private static void heapSort(int[] arr) {
        int n = arr.length;

        // One by one extract elements from the heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Call max heapify on the reduced heap
            heapifyUtil(arr, i, 0);
        }
    }
}
