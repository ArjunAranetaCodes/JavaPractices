public class Main {
    public static void main(String[] args) {
        double angleInDegrees = 30;
        double angleInRadians = Math.toRadians(angleInDegrees);
        double sinValue = Math.sin(angleInRadians);
        System.out.println("Sine of " + angleInDegrees + " degrees: " + sinValue);
    }
}
    