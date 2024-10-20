import java.util.Arrays;
public class ArrayCloningMultiple {
    public static void main(String[] args) {
        int[][] original = {{1, 2}, {3, 4}, {5, 6}};
        int[][] cloned = Arrays.copyOf(original, original.length);

        for (int i = 0; i < cloned.length; i++) {
            cloned[i] = Arrays.copyOf(original[i], original[i].length);
        }

        System.out.println("Original array: " + Arrays.deepToString(original));
        System.out.println("Cloned array: " + Arrays.deepToString(cloned));
    }
}