public class Main {
    public static void main(String[] args) {
        for (double angle = 0; angle <= 180; angle += 30) {
            double angleInRadians = Math.toRadians(angle);
            double cosineValue = Math.cos(angleInRadians);
            System.out.println("Cosine value of " + angle + " degrees: " + cosineValue);
        }
    }
}
 