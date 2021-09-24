public class Main {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        int target = 3;

        boolean contains = false;
        for (int number : numbers) {
            if (number == target) {
                contains = true;
                break;
            }
        }

        if (contains) {
            System.out.println("The array contains the target number.");
        } else {
            System.out.println("The array does not contain the target number.");
        }
    }
}
