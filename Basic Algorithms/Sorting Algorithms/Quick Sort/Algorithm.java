public class Algorithm {
    public static void main(String[] args) {
        int[] array = {5, 2, 9, 1, 5, 6};
        
        System.out.println("Original Array:");
        printArray(array);
        
        quickSort(array, 0, array.length - 1);
        
        System.out.println("Sorted Array:");
        printArray(array);
    }

    // Quick Sort implementation
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);

            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    // Helper method to partition the array
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];


    }

}
