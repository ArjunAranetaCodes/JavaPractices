public class Main {
    public static void main(String[] args) {
        double value = 1.0;
        double epsilon = 1e-9; // A small value for comparison

        System.out.println("Original Value: " + value);

        if (Math.abs(Math.ulp(value)) < epsilon) {
            System.out.println("The value is close to zero within the specified epsilon.");
        } else {
            System.out.println("The value is not close to zero within the specified epsilon.");
        }
    }
}
