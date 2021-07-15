public class Main {
    public static void main(String[] args) {
        double base = 2;
        double exponent = 3;
        double result = 1;

        for (int i = 0; i < exponent; i++) {
            result *= Math.pow(base, 1);
        }

        System.out.println("Result: " + result);
    }
}
