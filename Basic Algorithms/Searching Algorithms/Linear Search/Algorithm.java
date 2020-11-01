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

}
