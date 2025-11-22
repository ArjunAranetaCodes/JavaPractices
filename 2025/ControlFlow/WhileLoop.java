/**
 * Tutorial: While Loops
 * Demonstrates while loop and do-while loop
 */
public class WhileLoop {
    public static void main(String[] args) {
        // While loop
        System.out.println("While loop:");
        int i = 1;
        while (i <= 5) {
            System.out.print(i + " ");
            i++;
        }
        System.out.println();
        
        // Do-while loop
        System.out.println("\nDo-while loop:");
        int j = 1;
        do {
            System.out.print(j + " ");
            j++;
        } while (j <= 5);
        System.out.println();
        
        // Difference: do-while executes at least once
        System.out.println("\nDo-while executes at least once:");
        int k = 10;
        do {
            System.out.println("This executes even though k > 5");
            k++;
        } while (k <= 5);
        
        // While loop with condition
        System.out.println("\nWhile loop - countdown:");
        int count = 5;
        while (count > 0) {
            System.out.print(count + " ");
            count--;
        }
        System.out.println("Blast off!");
        
        // Sum of numbers
        System.out.println("\nSum of numbers 1 to 10:");
        int sum = 0;
        int num = 1;
        while (num <= 10) {
            sum += num;
            num++;
        }
        System.out.println("Sum: " + sum);
    }
}
















