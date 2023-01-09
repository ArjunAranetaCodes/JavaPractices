public class Main {
    public static void main(String[] args) {
        int base = 2;
        int exponent = 3;
        int result = 1;
        int i = 1;
        while (i <= exponent) {
            result *= base;
        }
        System.out.println(base + " raised to the power of " + exponent + " is: " + result);
    }
}
