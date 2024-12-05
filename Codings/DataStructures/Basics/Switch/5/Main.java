public class Main {
    public static void main(String[] args) {
        int number = 2;

        switch (number) {
            case 1:
            case 2:
            case 3:
                System.out.println("Number is between 1 and 3");
                break;
            case 4:
            case 5:
                System.out.println("Number is between 4 and 5");
                break;
            default:
                System.out.println("Number is out of range");
        }
    }
}
