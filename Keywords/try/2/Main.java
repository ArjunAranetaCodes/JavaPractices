public class Main {
    public static void main(String[] args) {
        try {
            // Code that may throw an exception
            int result = 10 / 0; // ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Finally block executed");
        }
    }
}
