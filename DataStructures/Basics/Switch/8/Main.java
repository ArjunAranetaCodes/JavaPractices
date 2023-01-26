public class Main {
    public static void main(String[] args) {
        int x = 5;
        int y = 10;
        char operation = '*';

        switch (operation) {
            case '+':
                System.out.println("Sum: " + (x + y));
                break;
            case '-':
                System.out.println("Difference: " + (x - y));
                break;
            case '*':
                System.out.println("Product: " + (x * y));
                break;
            case '/':
                System.out.println("Quotient: " + (x / y));
                break;
            default:
                System.out.println("Invalid operation");
        }
    }
}
