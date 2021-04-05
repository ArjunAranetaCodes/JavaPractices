public class Main {
    public static void main(String[] args) {
        double radius = 5.0;
        double centralAngleDegrees = 60.0;

        double centralAngleRadians = Math.toRadians(centralAngleDegrees);
        double area = 0.5 * Math.pow(radius, 2) * centralAngleRadians;

        System.out.println("Area of the sector: " + area);
    }
}
