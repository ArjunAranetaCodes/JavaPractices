public class Main {
    public static void main(String[] args) {
        double value = -7.2;

        if (Math.signum(value) > 0) {
            System.out.println(value + " is positive.");
        } else if (Math.signum(value) < 0) {
            System.out.println(value + " is negative.");
        } else {
            System.out.println(value + " is zero.");
        }
    }
}
 