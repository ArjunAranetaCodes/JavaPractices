import java.io.*;
import java.util.*;

/**
 * Comprehensive Exception Handling Examples
 * This program demonstrates various types of exceptions and how to handle them properly
 */
public class ExceptionExamples {
    
    public static void main(String[] args) {
        System.out.println("=== Java Exception Handling Tutorial ===\n");
        
        // 1. Checked Exceptions (Compile-time exceptions)
        demonstrateCheckedExceptions();
        
        // 2. Unchecked Exceptions (Runtime exceptions)
        demonstrateUncheckedExceptions();
        
        // 3. Custom Exceptions
        demonstrateCustomExceptions();
        
        // 4. Try-with-resources
        demonstrateTryWithResources();
        
        // 5. Multiple catch blocks
        demonstrateMultipleCatchBlocks();
        
        // 6. Finally block
        demonstrateFinallyBlock();
        
        // 7. Exception propagation
        demonstrateExceptionPropagation();
        
        System.out.println("\n=== Tutorial Complete ===");
    }
    
    /**
     * Demonstrates checked exceptions that must be handled at compile time
     */
    public static void demonstrateCheckedExceptions() {
        System.out.println("1. CHECKED EXCEPTIONS (Compile-time exceptions):");
        System.out.println("   These must be handled or declared in method signature\n");
        
        // FileNotFoundException example
        try {
            FileReader fileReader = new FileReader("nonexistent.txt");
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("   ✓ FileNotFoundException caught: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("   ✓ IOException caught: " + e.getMessage());
        }
        
        // InterruptedException example
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("   ✓ InterruptedException caught: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates unchecked exceptions that occur at runtime
     */
    public static void demonstrateUncheckedExceptions() {
        System.out.println("2. UNCHECKED EXCEPTIONS (Runtime exceptions):");
        System.out.println("   These don't need to be explicitly handled\n");
        
        // NullPointerException
        try {
            String str = null;
            int length = str.length(); // This will throw NullPointerException
        } catch (NullPointerException e) {
            System.out.println("   ✓ NullPointerException caught: " + e.getMessage());
        }
        
        // ArrayIndexOutOfBoundsException
        try {
            int[] numbers = {1, 2, 3};
            int value = numbers[5]; // This will throw ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("   ✓ ArrayIndexOutOfBoundsException caught: " + e.getMessage());
        }
        
        // NumberFormatException
        try {
            int number = Integer.parseInt("abc"); // This will throw NumberFormatException
        } catch (NumberFormatException e) {
            System.out.println("   ✓ NumberFormatException caught: " + e.getMessage());
        }
        
        // ArithmeticException
        try {
            int result = 10 / 0; // This will throw ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("   ✓ ArithmeticException caught: " + e.getMessage());
        }
        
        // ClassCastException
        try {
            Object obj = "Hello";
            Integer num = (Integer) obj; // This will throw ClassCastException
        } catch (ClassCastException e) {
            System.out.println("   ✓ ClassCastException caught: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates custom exception creation and usage
     */
    public static void demonstrateCustomExceptions() {
        System.out.println("3. CUSTOM EXCEPTIONS:");
        System.out.println("   Creating and using your own exception classes\n");
        
        try {
            validateAge(-5);
        } catch (InvalidAgeException e) {
            System.out.println("   ✓ Custom InvalidAgeException caught: " + e.getMessage());
        }
        
        try {
            validateEmail("invalid-email");
        } catch (InvalidEmailException e) {
            System.out.println("   ✓ Custom InvalidEmailException caught: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates try-with-resources for automatic resource management
     */
    public static void demonstrateTryWithResources() {
        System.out.println("4. TRY-WITH-RESOURCES:");
        System.out.println("   Automatic resource management (Java 7+)\n");
        
        // Creating a temporary file for demonstration
        try {
            File tempFile = File.createTempFile("demo", ".txt");
            tempFile.deleteOnExit();
            
            // Write some content to the file
            try (FileWriter writer = new FileWriter(tempFile);
                 BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
                
                bufferedWriter.write("Hello, this is a demo file!");
                System.out.println("   ✓ File written successfully using try-with-resources");
                
            } // Resources are automatically closed here
            
            // Read the content back
            try (FileReader reader = new FileReader(tempFile);
                 BufferedReader bufferedReader = new BufferedReader(reader)) {
                
                String line = bufferedReader.readLine();
                System.out.println("   ✓ File read successfully: " + line);
                
            } // Resources are automatically closed here
            
        } catch (IOException e) {
            System.out.println("   ✗ IOException: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates multiple catch blocks for different exception types
     */
    public static void demonstrateMultipleCatchBlocks() {
        System.out.println("5. MULTIPLE CATCH BLOCKS:");
        System.out.println("   Handling different types of exceptions\n");
        
        try {
            // Simulate different types of errors
            Random random = new Random();
            int choice = random.nextInt(4);
            
            switch (choice) {
                case 0:
                    throw new NullPointerException("Simulated null pointer");
                case 1:
                    throw new IllegalArgumentException("Simulated illegal argument");
                case 2:
                    throw new RuntimeException("Simulated runtime exception");
                case 3:
                    throw new ArithmeticException("Simulated arithmetic exception");
            }
            
        } catch (NullPointerException e) {
            System.out.println("   ✓ NullPointerException handled: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("   ✓ IllegalArgumentException handled: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("   ✓ ArithmeticException handled: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("   ✓ RuntimeException handled: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates the finally block execution
     */
    public static void demonstrateFinallyBlock() {
        System.out.println("6. FINALLY BLOCK:");
        System.out.println("   Code that always executes regardless of exceptions\n");
        
        try {
            System.out.println("   → Inside try block");
            // Simulate an exception
            throw new RuntimeException("Test exception");
        } catch (RuntimeException e) {
            System.out.println("   → Inside catch block: " + e.getMessage());
        } finally {
            System.out.println("   → Inside finally block (always executes)");
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates exception propagation through method calls
     */
    public static void demonstrateExceptionPropagation() {
        System.out.println("7. EXCEPTION PROPAGATION:");
        System.out.println("   How exceptions bubble up through the call stack\n");
        
        try {
            methodA();
        } catch (Exception e) {
            System.out.println("   ✓ Exception caught in main: " + e.getMessage());
            System.out.println("   → Stack trace:");
            e.printStackTrace();
        }
        
        System.out.println();
    }
    
    // Helper methods for custom exceptions
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 0 || age > 150) {
            throw new InvalidAgeException("Age must be between 0 and 150, got: " + age);
        }
        System.out.println("   ✓ Valid age: " + age);
    }
    
    public static void validateEmail(String email) throws InvalidEmailException {
        if (email == null || !email.contains("@")) {
            throw new InvalidEmailException("Invalid email format: " + email);
        }
        System.out.println("   ✓ Valid email: " + email);
    }
    
    // Methods for exception propagation demonstration
    public static void methodA() throws Exception {
        System.out.println("   → Method A called");
        methodB();
    }
    
    public static void methodB() throws Exception {
        System.out.println("   → Method B called");
        methodC();
    }
    
    public static void methodC() throws Exception {
        System.out.println("   → Method C called");
        throw new Exception("Exception thrown in method C");
    }
}

/**
 * Custom exception for invalid age
 */
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

/**
 * Custom exception for invalid email
 */
class InvalidEmailException extends Exception {
    public InvalidEmailException(String message) {
        super(message);
    }
} 