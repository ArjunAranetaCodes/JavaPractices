public class Main {
    public static void main(String[] args) {
        int dayOfWeek = 2;

        switch (dayOfWeek) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            // Add cases for other days as needed
            default:
                System.out.println("Invalid day");
        }
    }
}
