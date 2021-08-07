public class Main {
    public static void main(String[] args) {
        float x = 7.8f;
        float y = -3.4f;
        float result = Math.copySign(x, y);
        System.out.println("Result: " + result);
    }
}
   