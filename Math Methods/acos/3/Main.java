public class Main {
    public static void main(String[] args) {
        double[] angles = { 0.1, 0.3, 0.5, 0.7, 0.9 };
        System.out.println("Arccosine values:");
        for (double angle : angles) {
            double result = Math.acos(angle);
            System.out.println("Angle: " + angle + ", Arccosine: " + result);
        }
    }
}
