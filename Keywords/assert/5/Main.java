public class Main {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        int index = 10;
        assert index >= 0 && index < numbers.length : "Index out of bounds";
        System.out.println("Value at index " + index + ": " + numbers[index]);
    }
