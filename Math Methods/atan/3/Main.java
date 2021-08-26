public class Main {
    public static void main(String[] args) {
        double angleDegrees = 45;
        double angleRadians = Math.toRadians(angleDegrees);
        double result = Math.atan(angleRadians);
        System.out.println("The arctangent of " + angleDegrees + " degrees is: " + result);
    }
}
  