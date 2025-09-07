public class Main {
    public static void main(String[] args) {
        long result = addTwoNumbers(123456789L, 987654321L);
        System.out.println("Sum: " + result);
    }

    private static long addTwoNumbers(long num1, long num2) {
        return num1 + num2;
    }
}
