public class Main {
    public static void main(String[] args) {
        checkNumber(10);
        checkNumber(3);
    }

    static void checkNumber(int number) {
        if (number > 5) {
            System.out.println(number + " is greater than 5.");
        } else {
            System.out.println(number + " is not greater than 5.");
        }
    }
}
