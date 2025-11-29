/**
 * Tutorial: If-Else Statements
 * Demonstrates if, if-else, if-else-if ladder
 */
public class IfElse {
    public static void main(String[] args) {
        int number = 15;
        
        // Simple if statement
        if (number > 0) {
            System.out.println(number + " is positive");
        }
        
        // If-else statement
        if (number % 2 == 0) {
            System.out.println(number + " is even");
        } else {
            System.out.println(number + " is odd");
        }
        
        // If-else-if ladder
        int score = 85;
        if (score >= 90) {
            System.out.println("Grade: A");
        } else if (score >= 80) {
            System.out.println("Grade: B");
        } else if (score >= 70) {
            System.out.println("Grade: C");
        } else if (score >= 60) {
            System.out.println("Grade: D");
        } else {
            System.out.println("Grade: F");
        }
        
        // Nested if-else
        int age = 25;
        boolean hasLicense = true;
        if (age >= 18) {
            if (hasLicense) {
                System.out.println("Can drive");
            } else {
                System.out.println("Need license to drive");
            }
        } else {
            System.out.println("Too young to drive");
        }
    }
}


















