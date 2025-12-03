/**
 * Tutorial: Try-Catch Blocks
 * Demonstrates exception handling with try-catch
 */
public class TryCatch {
    public static void main(String[] args) {
        // Basic try-catch
        try {
            int result = 10 / 0;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero");
            System.out.println("Exception: " + e.getMessage());
        }
        
        // Multiple catch blocks
        try {
            int[] arr = new int[5];
            arr[10] = 100;  // ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index out of bounds");
        } catch (Exception e) {
            System.out.println("General exception: " + e.getMessage());
        }
        
        // Try with multiple operations
        try {
            String str = null;
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.out.println("Null pointer exception caught");
        }
        
        System.out.println("Program continues after exception handling");
    }
}


















