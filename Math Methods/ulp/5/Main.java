public class Main {
    public static void main(String[] args) {
        float floatValue = 1.0f;

        System.out.println("Original Float Value: " + floatValue);
        System.out.println("ULP of Float Value: " + Math.ulp(floatValue));

        double doubleValue = 1.0;

        System.out.println("Original Double Value: " + doubleValue);
        System.out.println("ULP of Double Value: " + Math.ulp(doubleValue));
    }
}
