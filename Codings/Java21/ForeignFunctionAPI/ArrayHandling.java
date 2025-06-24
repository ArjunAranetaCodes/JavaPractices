import java.lang.foreign.*;
import java.util.Arrays;

public class ArrayHandling {
    public static void main(String[] args) {
        try (Arena arena = Arena.ofConfined()) {
            // Example 1: Primitive array
            int[] javaArray = {1, 2, 3, 4, 5};
            MemorySegment nativeArray = arena.allocateArray(ValueLayout.JAVA_INT, javaArray);
            
            System.out.println("Original Java array: " + Arrays.toString(javaArray));
            
            // Read back from native memory
            int[] readBack = new int[javaArray.length];
            for (int i = 0; i < javaArray.length; i++) {
                readBack[i] = nativeArray.get(ValueLayout.JAVA_INT, i * 4);
            }
            System.out.println("Read back from native memory: " + Arrays.toString(readBack));
            
            // Example 2: 2D array
            int[][] java2DArray = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
            };
            
            // Allocate memory for 2D array
            MemorySegment native2DArray = arena.allocateArray(
                MemoryLayout.sequenceLayout(3, ValueLayout.JAVA_INT),
                3
            );
            
            // Copy data to native memory
            for (int i = 0; i < 3; i++) {
                MemorySegment row = native2DArray.asSlice(i * 3 * 4);
                for (int j = 0; j < 3; j++) {
                    row.set(ValueLayout.JAVA_INT, j * 4, java2DArray[i][j]);
                }
            }
            
            // Read back 2D array
            int[][] readBack2D = new int[3][3];
            for (int i = 0; i < 3; i++) {
                MemorySegment row = native2DArray.asSlice(i * 3 * 4);
                for (int j = 0; j < 3; j++) {
                    readBack2D[i][j] = row.get(ValueLayout.JAVA_INT, j * 4);
                }
            }
            
            System.out.println("\nOriginal 2D array:");
            for (int[] row : java2DArray) {
                System.out.println(Arrays.toString(row));
            }
            
            System.out.println("\nRead back 2D array:");
            for (int[] row : readBack2D) {
                System.out.println(Arrays.toString(row));
            }
            
            // Example 3: String array
            String[] strings = {"Hello", "World", "Java", "FFM"};
            MemorySegment stringArray = arena.allocateArray(ValueLayout.ADDRESS, strings.length);
            
            // Allocate and store strings
            for (int i = 0; i < strings.length; i++) {
                MemorySegment str = arena.allocateUtf8String(strings[i]);
                stringArray.set(ValueLayout.ADDRESS, i * 8, str);
            }
            
            // Read back strings
            String[] readBackStrings = new String[strings.length];
            for (int i = 0; i < strings.length; i++) {
                MemorySegment strPtr = stringArray.get(ValueLayout.ADDRESS, i * 8);
                readBackStrings[i] = strPtr.getUtf8String(0);
            }
            
            System.out.println("\nOriginal strings: " + Arrays.toString(strings));
            System.out.println("Read back strings: " + Arrays.toString(readBackStrings));
        }
    }
} 