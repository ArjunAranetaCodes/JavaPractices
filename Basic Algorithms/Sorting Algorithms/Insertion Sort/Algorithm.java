public class Algorithm {

    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6};

        System.out.println("Original array:");
        printArray(array);

        insertionSort(array);

        System.out.println("\nSorted array using Insertion Sort:");
        printArray(array);
    }

    static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
    }
}
