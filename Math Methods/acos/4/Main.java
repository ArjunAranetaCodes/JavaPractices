public class Main {
    public static void main(String[] args) {
        double angle = 0.3; // Input angle in radians
        double cosineValue = Math.cos(angle);
        double result = Math.acos(cosineValue);
        System.out.println("Cosine of " + angle + " is: " + cosineValue);
        System.out.println("Arccosine of cosine(" + angle + ") is: " + result);
    }
}
 