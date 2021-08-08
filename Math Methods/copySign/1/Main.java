public class Main {
    public static void main(String[] args) {
        double x = 10.5;
        double y = -5.2;
        double result = Math.copySign(x, y);
        System.out.println("Result: " + result);
    }
}
 