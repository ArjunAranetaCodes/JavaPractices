public class Main {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4};
        swap(arr, 0, 2);
        System.out.println(Arrays.toString(arr));  // Output: [3, 2, 1, 4]
    }

    static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
  