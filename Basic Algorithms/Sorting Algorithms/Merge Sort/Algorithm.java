public class Algorithm {

    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7};

        System.out.println("Original array:");
        printArray(array);

        mergeSort(array, 0, array.length - 1);

        System.out.println("\nSorted array:");
        printArray(array);
    }

    // Merge Sort function


}
