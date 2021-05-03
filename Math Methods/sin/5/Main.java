public class Main {
    public static void main(String[] args) {
        int startAngle = 0;
        int endAngle = 360;
        int step = 45;

        for (int angleInDegrees = startAngle; angleInDegrees <= endAngle; angleInDegrees += step) {
            double angleInRadians = Math.toRadians(angleInDegrees);
            double sinValue = Math.sin(angleInRadians);
            System.out.println("Sine of " + angleInDegrees + " degrees: " + sinValue);
        }
    }
}
