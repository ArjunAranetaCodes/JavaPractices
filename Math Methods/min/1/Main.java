public class Main {
    public static void main(String[] args) {
        int[] numbers = {5, 2, 8, 1, 7};
        int min = findMin(numbers);
        System.out.println("Minimum value in the array: " + min);
    }

    static int findMin(int[] arr) {
        int min = arr[0];
        for (int num : arr) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }
}
