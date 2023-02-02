public class Main {
    public static void main(String[] args) {
        char grade = 'B';

        switch (grade) {
            case 'A':
                System.out.println("Excellent");
                break;
            case 'B':
                System.out.println("Good");
                break;
            // Add cases for other grades as needed
            default:
                System.out.println("Invalid grade");
        }
    }
}
