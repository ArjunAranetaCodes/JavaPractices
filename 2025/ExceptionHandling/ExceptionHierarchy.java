/**
 * Tutorial: Exception Hierarchy
 * Demonstrates exception class hierarchy
 */
public class ExceptionHierarchy {
    public static void main(String[] args) {
        // Throwable is the root
        // Error - serious problems (usually not caught)
        // Exception - checked exceptions
        // RuntimeException - unchecked exceptions
        
        // Catching specific exceptions
        try {
            int[] arr = new int[5];
            arr[10] = 100;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Specific: ArrayIndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Parent: IndexOutOfBoundsException");
        } catch (RuntimeException e) {
            System.out.println("Grandparent: RuntimeException");
        } catch (Exception e) {
            System.out.println("Root: Exception");
        }
        
        System.out.println();
        
        // Order matters - most specific first
        try {
            String str = null;
            str.length();
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException caught");
        } catch (Exception e) {
            System.out.println("Exception caught");
        }
    }
}


















