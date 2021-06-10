public class Main {
    public static void main(String[] args) {
        int min = findMin(7, 2, 9, 1, 5);
        System.out.println("Minimum value using varargs: " + min);
    }

    static int findMin(int... numbers) {
        int min = numbers[0];
        for (int num : numbers) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }
}
  