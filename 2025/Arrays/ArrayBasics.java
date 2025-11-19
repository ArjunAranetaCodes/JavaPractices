/**
 * Tutorial: Array Basics
 * Demonstrates array declaration, initialization, and access
 */
public class ArrayBasics {
    public static void main(String[] args) {
        // Array declaration and initialization
        int[] numbers = new int[5];
        numbers[0] = 10;
        numbers[1] = 20;
        numbers[2] = 30;
        numbers[3] = 40;
        numbers[4] = 50;
        
        // Array initialization with values
        int[] arr = {1, 2, 3, 4, 5};
        
        // Accessing array elements
        System.out.println("First element: " + arr[0]);
        System.out.println("Last element: " + arr[arr.length - 1]);
        
        // Iterating through array
        System.out.println("\nArray elements:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        
        // Enhanced for loop
        System.out.println("\nUsing enhanced for loop:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        // Array of different types
        String[] names = {"Alice", "Bob", "Charlie"};
        double[] prices = {10.5, 20.75, 30.25};
        
        System.out.println("\nNames:");
        for (String name : names) {
            System.out.println(name);
        }
    }
}













