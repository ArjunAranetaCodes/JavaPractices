public class Main {
    public static void main(String[] args) {
        double[] numbers = {8.0, 64.0, 125.0};
        
        for (double num : numbers) {
            double cubeRoot = Math.cbrt(num);
            System.out.println("Cube root of " + num + " is: " + cubeRoot);
        }
    }
}
 