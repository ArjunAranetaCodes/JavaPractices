public class Main {
    public static void main(String[] args) {
        double startValue = 1.0;

        for (int i = 0; i < 5; i++) {
            double ulpValue = Math.ulp(startValue);
            System.out.println("Iteration " + (i + 1) + ": ULP of " + startValue + " is " + ulpValue);
            startValue *= 2.0; // Doubling the value for each iteration
        }
    }
}
  