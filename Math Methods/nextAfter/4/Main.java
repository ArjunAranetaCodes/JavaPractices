public class Main {
    public static void main(String[] args) {
        float startValue = 1.0f;
        float nextAfterValue = Math.nextAfter(startValue, Double.POSITIVE_INFINITY);
        System.out.println("Next after " + startValue + " towards positive infinity: " + nextAfterValue);
    }
}
  