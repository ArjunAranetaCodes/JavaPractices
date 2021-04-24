public class Main {
    public static void main(String[] args) {
        double a = 1.0, b = -3.0, c = 2.0;
        
        double discriminant = b * b - 4 * a * c;
        
        if (discriminant >= 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("Roots of the quadratic equation are: " + root1 + " and " + root2);
        } else {
            System.out.println("The quadratic equation has complex roots.");
        }
    }
}
  