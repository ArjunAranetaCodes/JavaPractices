public class Main {
    public static void main(String[] args) {
        double angleInDegrees = 45;
        double angleInRadians = Math.toRadians(angleInDegrees);
        double cosineValue = Math.cos(angleInRadians);
        System.out.println("Cosine value of " + angleInDegrees + " degrees: " + cosineValue);
    }
}
 