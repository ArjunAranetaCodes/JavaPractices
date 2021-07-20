public class Main {
    public static void main(String[] args) {
        int[] array = { 15, 28, 41, 53, 67 };

        System.out.println("Original Array:");
        for (int num : array) {
            System.out.print(num + " ");
        }

        System.out.println("\nFloor Values:");
        for (int num : array) {
            System.out.print(Math.floor(num) + " ");
        }
    }
}
   