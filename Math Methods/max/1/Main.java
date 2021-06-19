public class Main {
    public static void main(String[] args) {
        int[] numbers = {5, 2, 8, 12, 7};
        int max = findMax(numbers);
        System.out.println("Maximum value in the array: " + max);
    }

    static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
  