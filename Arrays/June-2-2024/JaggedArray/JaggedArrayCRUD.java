import java.util.Arrays;

public class JaggedArrayCRUD {
    public static void main(String[] args) {
        // Create
        int[][] jaggedArray = {{1, 2}, {3, 4, 5}, {6, 7, 8, 9}};

        // Read
        System.out.println("After Create: " + Arrays.deepToString(jaggedArray));

        // Update
        jaggedArray[1] = new int[]{10, 11, 12};
        System.out.println("After Update: " + Arrays.deepToString(jaggedArray));

        // Delete
        jaggedArray = Arrays.copyOf(jaggedArray, jaggedArray.length - 1);
        System.out.println("After Delete: " + Arrays.deepToString(jaggedArray));
    }
}