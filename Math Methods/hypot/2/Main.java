public class Main {
    static double calculateExponent(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    public static void main(String[] args) {
        double base = 2;
        double exponent = 3;
        double result = calculateExponent(base, exponent);
        System.out.println("Result: " + result);
    }
}
 