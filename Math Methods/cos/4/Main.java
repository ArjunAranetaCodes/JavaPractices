public class Main {
    public static void main(String[] args) {
        float x = 5.0f;
        float y = -2.5f;
        float result = Math.copySign(x, y);
        System.out.println("Result: " + result);
    }
}
