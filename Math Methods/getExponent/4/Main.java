public class Main {
    static double calculateExponent(double base, double exponent) {
        double result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }

    public static void main(String[] args) {
        double base = 2;
        double exponent = 3;
        double result = calculateExponent(base, exponent);
        System.out.println("Result: " + result);
    }
}
