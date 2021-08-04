public class Main {
    public static void main(String[] args) {
        double x = 3.14;
        double y = -2.71;
        double result = Math.copySign(x, y);
        System.out.println("Result: " + result);
    }
}
    