public class Main {
    public static void main(String[] args) {
        double angleInDegrees = 45;

        // Sine, Cosine, Tangent
        double sine = Math.sin(Math.toRadians(angleInDegrees));
        double cosine = Math.cos(Math.toRadians(angleInDegrees));
        double tangent = Math.tan(Math.toRadians(angleInDegrees));

        System.out.println("Sine: " + sine);
        System.out.println("Cosine: " + cosine);
        System.out.println("Tangent: " + tangent);
    }
}
