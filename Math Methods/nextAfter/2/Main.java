public class Main {
    public static void main(String[] args) {
        float startValue = 2.0f;
        float nextAfterValue = Math.nextAfter(startValue, Double.NEGATIVE_INFINITY);
        System.out.println("Next after " + startValue + " towards negative infinity: " + nextAfterValue);
    }
}
