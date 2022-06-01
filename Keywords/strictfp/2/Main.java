public class Main {
    strictfp static double calculateSquare(double num) {
        return num * num;
    }

    strictfp static float calculateCube(float num) {
        return num * num * num;
    }

    public static void main(String[] args) {
        double squareResult = calculateSquare(3.5);
        float cubeResult = calculateCube(2.0f);

        System.out.println("Square Result: " + squareResult);
        System.out.println("Cube Result: " + cubeResult); 
    }
}
