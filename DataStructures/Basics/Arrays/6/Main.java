public class Main {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        int target = 3;
        boolean containsTarget = false;

        for (int num : numbers) {
            if (num == target) {
                containsTarget = true;
                break;
            }
        }

        System.out.println("Array contains " + target + ": " + containsTarget);
    }
}
