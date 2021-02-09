public class Algorithm {

    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6};

        System.out.println("Original array:");
        printArray(array);

        insertionSort(array);

        System.out.println("\nSorted array using Insertion Sort:");
        printArray(array);
    }



}
