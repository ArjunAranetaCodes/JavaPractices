public class Main {
    public static void main(String[] args) {
        long number = 123456789012345L;

        switch ((int) (number % 10)) {
            case 1:
                System.out.println("Ends with 1");
                break;
            case 2:
                System.out.println("Ends with 2");
                break;
            default:
        }
    }
}
