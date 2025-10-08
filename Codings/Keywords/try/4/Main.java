public class Main {
    public static void main(String[] args) {
        try {
            try {
                // Code that may throw an exception
                int result = 10 / 0; // ArithmeticException
            } catch (ArithmeticException e) {
                System.out.println("Inner Catch: " + e.getMessage());
            }
            
            // Code outside the inner try-catch block
            String str = null;
            System.out.println(str.length()); // NullPointerException
        } catch (NullPointerException e) {
            System.out.println("Outer Catch: " + e.getMessage());
        }
    }
}
