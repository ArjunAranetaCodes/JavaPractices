public class Main {
    public static void main(String[] args) {
        try {
            int result = 10 / 0; // ArithmeticException will be thrown
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException: " + e.getMessage());
        }
    }
}
