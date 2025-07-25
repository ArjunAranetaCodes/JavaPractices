import java.util.Scanner;

/**
 * Simple Exception Test Program
 * Interactive program to test exception handling concepts
 */
public class ExceptionTest {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Exception Handling Test Program ===\n");
        
        while (true) {
            System.out.println("Choose a test:");
            System.out.println("1. Division by zero");
            System.out.println("2. Array index out of bounds");
            System.out.println("3. Null pointer exception");
            System.out.println("4. Number format exception");
            System.out.println("5. Custom exception");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");
            
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                
                switch (choice) {
                    case 1:
                        testDivisionByZero();
                        break;
                    case 2:
                        testArrayIndexOutOfBounds();
                        break;
                    case 3:
                        testNullPointerException();
                        break;
                    case 4:
                        testNumberFormatException();
                        break;
                    case 5:
                        testCustomException();
                        break;
                    case 6:
                        System.out.println("Goodbye!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please enter 1-6.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            }
            
            System.out.println("\n" + "=".repeat(50) + "\n");
        }
    }
    
    public static void testDivisionByZero() {
        System.out.println("\n--- Testing Division by Zero ---");
        
        try {
            System.out.print("Enter first number: ");
            Scanner scanner = new Scanner(System.in);
            int a = Integer.parseInt(scanner.nextLine());
            
            System.out.print("Enter second number: ");
            int b = Integer.parseInt(scanner.nextLine());
            
            int result = a / b;
            System.out.println("Result: " + result);
            
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed!");
            System.out.println("Exception: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter valid numbers!");
        }
    }
    
    public static void testArrayIndexOutOfBounds() {
        System.out.println("\n--- Testing Array Index Out of Bounds ---");
        
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println("Array: [1, 2, 3, 4, 5] (length: " + numbers.length + ")");
        
        try {
            System.out.print("Enter index to access (0-4): ");
            Scanner scanner = new Scanner(System.in);
            int index = Integer.parseInt(scanner.nextLine());
            
            int value = numbers[index];
            System.out.println("Value at index " + index + ": " + value);
            
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Index is out of bounds!");
            System.out.println("Exception: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter a valid number!");
        }
    }
    
    public static void testNullPointerException() {
        System.out.println("\n--- Testing Null Pointer Exception ---");
        
        try {
            String str = null;
            System.out.println("Attempting to get length of null string...");
            int length = str.length(); // This will throw NullPointerException
            System.out.println("Length: " + length);
            
        } catch (NullPointerException e) {
            System.out.println("Error: Cannot call methods on null objects!");
            System.out.println("Exception: " + e.getMessage());
        }
    }
    
    public static void testNumberFormatException() {
        System.out.println("\n--- Testing Number Format Exception ---");
        
        try {
            System.out.print("Enter a number as string: ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            
            int number = Integer.parseInt(input);
            System.out.println("Parsed number: " + number);
            
        } catch (NumberFormatException e) {
            System.out.println("Error: Cannot convert string to number!");
            System.out.println("Exception: " + e.getMessage());
        }
    }
    
    public static void testCustomException() {
        System.out.println("\n--- Testing Custom Exception ---");
        
        try {
            System.out.print("Enter your age: ");
            Scanner scanner = new Scanner(System.in);
            int age = Integer.parseInt(scanner.nextLine());
            
            validateAge(age);
            System.out.println("Valid age: " + age);
            
        } catch (InvalidAgeException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter a valid number!");
        }
    }
    
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 0) {
            throw new InvalidAgeException("Age cannot be negative: " + age);
        }
        if (age > 150) {
            throw new InvalidAgeException("Age seems unrealistic: " + age);
        }
    }
}

/**
 * Custom exception for age validation
 */
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
} 