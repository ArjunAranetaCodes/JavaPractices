/**
 * Tutorial: Switch-Case Statements
 * Demonstrates switch statement with different cases
 */
public class SwitchCase {
    public static void main(String[] args) {
        int day = 3;
        
        // Traditional switch statement
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Invalid day");
        }
        
        // Switch with multiple cases
        char grade = 'B';
        switch (grade) {
            case 'A':
            case 'a':
                System.out.println("Excellent");
                break;
            case 'B':
            case 'b':
                System.out.println("Good");
                break;
            case 'C':
            case 'c':
                System.out.println("Average");
                break;
            default:
                System.out.println("Needs improvement");
        }
        
        // Switch expression (Java 14+)
        String season = switch (day) {
            case 12, 1, 2 -> "Winter";
            case 3, 4, 5 -> "Spring";
            case 6, 7, 8 -> "Summer";
            case 9, 10, 11 -> "Fall";
            default -> "Invalid month";
        };
        System.out.println("Season: " + season);
    }
}
















