public class Main {
    public static void main(String[] args) {
        int result = calculate(-3, 2);
        System.out.println("Result is: " + result);
    }

    private static int calculate(int a, int b) {
        assert a >= 0 : "Input a must be non-negative";
        assert b >= 0 : "Input b must be non-negative";
        return a + b;
    }
}
