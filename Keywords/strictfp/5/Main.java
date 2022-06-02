import static java.lang.Math.PI;
import static java.lang.Math.sqrt;

public class Main {
    public static void main(String[] args) {
        double radius = 5.0;
        double area = PI * Math.pow(radius, 2);
        double side = 4.0;
        double diagonal = sqrt(2 * Math.pow(side, 2));

        System.out.println("Area of the circle: " + area);
        System.out.println("Diagonal of the square: " + diagonal);
    }
}
 