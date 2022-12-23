public class Main {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};
        double sum = 0;

        for (int num : numbers) {
            sum += num;
        }

        double average = sum / numbers.length;
    }
}
