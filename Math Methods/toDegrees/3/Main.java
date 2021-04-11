public class Main {
    public static void main(String[] args) {
        double[] radiansArray = { Math.PI / 6, Math.PI / 3, Math.PI / 2 }; // 30, 60, 90 degrees in radians

        for (double radians : radiansArray) {
            double degrees = Math.toDegrees(radians);
            System.out.println("Angle in radians: " + radians);
            System.out.println("Angle in degrees: " + degrees);
            System.out.println("---");
        }
    }
}
 