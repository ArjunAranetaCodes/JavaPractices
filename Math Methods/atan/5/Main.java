public class Main {
    public static void main(String[] args) {
        double[] angles = {0.3, 0.6, 0.9};
        for (double angle : angles) {
            double result = Math.atan(angle);
            System.out.println("The arctangent of " + angle + " is: " + result);
        }
    }
}
