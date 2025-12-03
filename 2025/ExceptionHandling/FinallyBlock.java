/**
 * Tutorial: Finally Block
 * Demonstrates finally block for cleanup
 */
public class FinallyBlock {
    public static void main(String[] args) {
        // Finally always executes
        try {
            int result = 10 / 2;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Exception caught");
        } finally {
            System.out.println("Finally block executed");
        }
        
        System.out.println();
        
        // Finally executes even when exception occurs
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Exception caught");
        } finally {
            System.out.println("Finally block executed even with exception");
        }
        
        System.out.println();
        
        // Finally with return statement
        System.out.println("Method returned: " + testFinally());
    }
    
    static int testFinally() {
        try {
            return 10;
        } finally {
            System.out.println("Finally executes before return");
        }
    }
}


















