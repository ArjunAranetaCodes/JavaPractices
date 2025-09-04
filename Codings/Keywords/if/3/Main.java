public class Main {
    public static void main(String[] args) {
        int num1 = 5, num2 = 10;

        if (num1 > 0) {
            if (num2 > 0) {
                System.out.println("Both numbers are positive.");
            } else {
                System.out.println("Num1 is positive, but num2 is non-positive.");
            }
        } else {
            System.out.println("Num1 is non-positive."); 
        }
    }
}
