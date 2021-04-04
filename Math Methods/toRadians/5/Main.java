public class Main {
    public static void main(String[] args) {
        System.out.println("Angle (degrees)\tSine\t\tCosine");
        
        for (int degrees = 0; degrees <= 180; degrees += 30) {
            double radians = Math.toRadians(degrees);
            double sineValue = Math.sin(radians);
            double cosineValue = Math.cos(radians);

            System.out.printf("%d\t\t\t%.4f\t\t%.4f\n", degrees, sineValue, cosineValue);
        }
    }
}
