/**
 * Tutorial: For Loops
 * Demonstrates for loop, enhanced for loop, nested loops
 */
public class ForLoop {
    public static void main(String[] args) {
        // Basic for loop
        System.out.println("Basic for loop:");
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        // Reverse for loop
        System.out.println("\nReverse for loop:");
        for (int i = 5; i >= 1; i--) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        // Enhanced for loop (for-each)
        System.out.println("\nEnhanced for loop:");
        int[] numbers = {10, 20, 30, 40, 50};
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        // Nested for loop
        System.out.println("\nNested for loop (multiplication table):");
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                System.out.print(i * j + "\t");
            }
            System.out.println();
        }
        
        // For loop with multiple variables
        System.out.println("\nFor loop with multiple variables:");
        for (int i = 0, j = 10; i < j; i++, j--) {
            System.out.println("i = " + i + ", j = " + j);
        }
    }
}










