import java.util.Arrays;

public class ArrayCloning {
    public static void main(String[] args) {
        int[] original = {1, 2, 3, 4, 5};
        int[] cloned = original.clone();

        System.out.println("Original array: " + Arrays.toString(original));
        System.out.println("Cloned array: " + Arrays.toString(cloned));
    }
}