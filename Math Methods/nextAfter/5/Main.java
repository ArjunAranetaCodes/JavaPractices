public class Main {
    public static void main(String[] args) {
        double startValue = -8.0;
        double nextAfterValue = Math.nextAfter(startValue, Double.NEGATIVE_INFINITY);
        System.out.println("Next after " + startValue + " towards negative infinity: " + nextAfterValue);
    }
}
