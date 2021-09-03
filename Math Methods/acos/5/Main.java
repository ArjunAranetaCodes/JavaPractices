public class Main {
    public static void main(String[] args) {
        double x = 0.6; // Some value for x
        double y = Math.sqrt(1 - x*x); // Calculating y using trigonometric identity
        double angle = Math.acos(x);
        System.out.println("For x=" + x + ", y=" + y + ", the angle is: " + angle);
    }
}
    