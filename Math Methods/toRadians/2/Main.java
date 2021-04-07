public class Main {
    public static void main(String[] args) {
        double angleInDegrees = 30.0;
        double angleInRadians = Math.toRadians(angleInDegrees);

        double sineValue = Math.sin(angleInRadians);
        double cosineValue = Math.cos(angleInRadians);

        System.out.println("Sine(" + angleInDegrees + " degrees) = " + sineValue);
        System.out.println("Cosine(" + angleInDegrees + " degrees) = " + cosineValue);
    }
}
