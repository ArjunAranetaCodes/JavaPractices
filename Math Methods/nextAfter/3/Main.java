public class Main {
    public static void main(String[] args) {
        double startValue = 10.0;
        double directionValue = 15.0;
        double nextAfterValue = Math.nextAfter(startValue, directionValue);
        System.out.println("Next after " + startValue + " towards " + directionValue + ": " + nextAfterValue);
    }
}
