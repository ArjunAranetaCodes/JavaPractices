public class Main {
    public static void main(String[] args) {
        System.out.println("Radians\t\tDegrees");
        for (double radians = 0; radians <= 2 * Math.PI; radians += Math.PI / 4) {
            double degrees = Math.toDegrees(radians);
            System.out.printf("%.2f\t\t%.2f\n", radians, degrees);
        }
    }
}
