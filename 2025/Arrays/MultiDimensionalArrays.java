/**
 * Tutorial: Multi-dimensional Arrays
 * Demonstrates 2D and 3D arrays
 */
public class MultiDimensionalArrays {
    public static void main(String[] args) {
        // 2D array declaration
        int[][] matrix = new int[3][3];
        
        // Initialize 2D array
        int[][] grid = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        // Accessing 2D array elements
        System.out.println("2D Array:");
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        
        // Jagged array (irregular array)
        int[][] jagged = new int[3][];
        jagged[0] = new int[]{1, 2};
        jagged[1] = new int[]{3, 4, 5};
        jagged[2] = new int[]{6, 7, 8, 9};
        
        System.out.println("\nJagged Array:");
        for (int i = 0; i < jagged.length; i++) {
            for (int j = 0; j < jagged[i].length; j++) {
                System.out.print(jagged[i][j] + " ");
            }
            System.out.println();
        }
        
        // 3D array
        int[][][] cube = new int[2][2][2];
        cube[0][0][0] = 1;
        cube[0][0][1] = 2;
        cube[0][1][0] = 3;
        cube[0][1][1] = 4;
        cube[1][0][0] = 5;
        cube[1][0][1] = 6;
        cube[1][1][0] = 7;
        cube[1][1][1] = 8;
        
        System.out.println("\n3D Array:");
        for (int i = 0; i < cube.length; i++) {
            for (int j = 0; j < cube[i].length; j++) {
                for (int k = 0; k < cube[i][j].length; k++) {
                    System.out.print(cube[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}


















