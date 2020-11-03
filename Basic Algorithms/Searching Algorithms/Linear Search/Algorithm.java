public class Algorithm {
    public static void main(String[] args) {
        // Sample array sorted in ascending order
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 6;

        // Perform binary search
        int result = binarySearch(array, target);

        // Display the result
        if (result != -1) {
            System.out.println("Element " + target + " found at index " + result);
        } else {
            System.out.println("Element " + target + " not found in the array");
        }
    }

    // Binary search method
    public static int binarySearch(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (array[mid] == target) {
            } else if (array[mid] < target) {
            } else {
            }
        }

    }
}
