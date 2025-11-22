/**
 * Tutorial: Break and Continue Statements
 * Demonstrates break, continue, and labeled statements
 */
public class BreakContinue {
    public static void main(String[] args) {
        // Break statement
        System.out.println("Break statement:");
        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                break;  // Exit loop when i is 5
            }
            System.out.print(i + " ");
        }
        System.out.println();
        
        // Continue statement
        System.out.println("\nContinue statement:");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                continue;  // Skip even numbers
            }
            System.out.print(i + " ");
        }
        System.out.println();
        
        // Labeled break
        System.out.println("\nLabeled break:");
        outer: for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                if (i == 2 && j == 2) {
                    break outer;  // Break outer loop
                }
                System.out.print(i + "," + j + " ");
            }
        }
        System.out.println();
        
        // Labeled continue
        System.out.println("\nLabeled continue:");
        outer: for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                if (i == 2 && j == 2) {
                    continue outer;  // Continue outer loop
                }
                System.out.print(i + "," + j + " ");
            }
        }
        System.out.println();
    }
}
















