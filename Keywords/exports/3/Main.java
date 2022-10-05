// Program 3
public class Main {
    enum Planet {
        MERCURY(3.303e+23, 2.4397e6),
        VENUS(4.869e+24, 6.0518e6),
        EARTH(5.976e+24, 6.3781e6);

        private final double mass;   // in kilograms
        private final double radius; // in meters

        Planet(double mass, double radius) {
            this.mass = mass;
            this.radius = radius;
        }

        public double getMass() {
            return mass;
        }

        public double getRadius() {
            return radius;
        }

        public double surfaceGravity() {
            return 6.67300e-11 * mass / (radius * radius);
        }
    }
 
    public static void main(String[] args) {
        Planet earth = Planet.EARTH;
        System.out.println("Mass: " + earth.getMass() + " kg");
        System.out.println("Radius: " + earth.getRadius() + " m");
        System.out.println("Surface Gravity: " + earth.surfaceGravity() + " N/kg");
    }
}
