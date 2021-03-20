public class Main {
    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4};
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4};
        printArray(intArray);    // Output: 1 2 3 4
        printArray(doubleArray); // Output: 1.1 2.2 3.3 4.4
    }

    static <T extends Number> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
 