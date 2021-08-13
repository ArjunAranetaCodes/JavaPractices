public class Main {
    public static void main(String[] args) {
        double[] numbers = {27.0, 64.0, 125.0};
        
        for (int i = 0; i < numbers.length; i++) {
            double cubeRoot = Math.cbrt(numbers[i]);
            System.out.println("Cube root of element at index " + i + " is: " + cubeRoot);
        }
    }
}
