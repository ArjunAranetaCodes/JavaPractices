public class Main {
    public static void main(String[] args) {
        int[] numbers = {5, 3, 8, 1, 7};
        int max = numbers[0];

        for (int num : numbers) {
            if (num > max) {
                max = num;
            }
        }

        System.out.println("Maximum element in array: " + max);
    }
}
