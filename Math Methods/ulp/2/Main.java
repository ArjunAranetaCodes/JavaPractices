public class Main {
    public static void main(String[] args) {
        double num1 = 0.1;
        double num2 = 0.2;

        System.out.println("Number 1: " + num1);
        System.out.println("Number 2: " + num2);

        if (Math.abs(num1 - num2) < Math.ulp(num1)) {
            System.out.println("The numbers are considered equal within the ULP tolerance.");
        } else {
            System.out.println("The numbers are not considered equal within the ULP tolerance.");
        }
    }
}
 