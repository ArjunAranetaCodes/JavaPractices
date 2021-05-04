public class Main {
    public static void main(String[] args) {
        double[] anglesInDegrees = {0, 45, 90, 135, 180};
        for (double angleInDegrees : anglesInDegrees) {
            double angleInRadians = Math.toRadians(angleInDegrees);
            double sinValue = Math.sin(angleInRadians);
            System.out.println("Sine of " + angleInDegrees + " degrees: " + sinValue);
        }
    }
}
