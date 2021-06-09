public class Main {
    public static void main(String[] args) {
        double startValue = 5.0;
        double nextAfterValue = Math.nextAfter(startValue, Double.POSITIVE_INFINITY);
        System.out.println("Next after " + startValue + " towards positive infinity: " + nextAfterValue);
    }
}
 