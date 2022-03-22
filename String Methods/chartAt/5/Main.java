public class Main {
    public static void main(String[] args) {
        int number = 12345;

        while (number > 0) {
            int digit = number % 10;
            System.out.println("Digit: " + digit);
            number /= 10;
        }
    }
}
