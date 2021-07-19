public class Main {
    public static void main(String[] args) {
        double[] numbers = { 5.8, 9.2, 3.7, 12.1 };
        
        System.out.println("Original Numbers:");
        for (double num : numbers) {
            System.out.print(num + " ");
        }
        
        System.out.println("\nFloor Values:");
        for (double num : numbers) {
            System.out.print(Math.floor(num) + " ");
        }
    }
}
   