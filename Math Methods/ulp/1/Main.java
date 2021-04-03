public class Main {
    public static void main(String[] args) {
        double value = 10.5;
        double ulpValue = Math.ulp(value);

        System.out.println("Original Value: " + value);
        System.out.println("ULP (Unit in the Last Place) Value: " + ulpValue);
    }
}
 