import java.io.*;
import java.util.*;
import java.util.logging.*;

/**
 * Exception Handling Best Practices
 * This program demonstrates proper exception handling patterns and best practices
 */
public class ExceptionBestPractices {
    
    private static final Logger LOGGER = Logger.getLogger(ExceptionBestPractices.class.getName());
    
    public static void main(String[] args) {
        System.out.println("=== Exception Handling Best Practices ===\n");
        
        // 1. Proper exception logging
        demonstrateProperLogging();
        
        // 2. Resource management
        demonstrateResourceManagement();
        
        // 3. Exception chaining
        demonstrateExceptionChaining();
        
        // 4. Specific exception handling
        demonstrateSpecificExceptionHandling();
        
        // 5. Exception suppression
        demonstrateExceptionSuppression();
        
        // 6. Performance considerations
        demonstratePerformanceConsiderations();
        
        // 7. Defensive programming
        demonstrateDefensiveProgramming();
        
        System.out.println("\n=== Best Practices Complete ===");
    }
    
    /**
     * Demonstrates proper exception logging practices
     */
    public static void demonstrateProperLogging() {
        System.out.println("1. PROPER EXCEPTION LOGGING:");
        System.out.println("   Log exceptions with appropriate levels and context\n");
        
        try {
            // Simulate an error
            throw new IOException("Database connection failed");
        } catch (IOException e) {
            // Good: Log with context and stack trace
            LOGGER.log(Level.SEVERE, "Failed to connect to database", e);
            
            // Good: Include relevant context
            LOGGER.log(Level.WARNING, "Retrying connection in 5 seconds...");
            
            System.out.println("   ✓ Exception properly logged with context");
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates proper resource management
     */
    public static void demonstrateResourceManagement() {
        System.out.println("2. RESOURCE MANAGEMENT:");
        System.out.println("   Always close resources properly\n");
        
        // Bad practice (old way)
        FileWriter writer = null;
        try {
            writer = new FileWriter("temp.txt");
            writer.write("Hello World");
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error writing to file", e);
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    LOGGER.log(Level.WARNING, "Error closing writer", e);
                }
            }
        }
        
        // Good practice (try-with-resources)
        try (FileWriter goodWriter = new FileWriter("temp2.txt")) {
            goodWriter.write("Hello World");
            System.out.println("   ✓ Resource automatically managed with try-with-resources");
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error writing to file", e);
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates exception chaining (wrapping exceptions)
     */
    public static void demonstrateExceptionChaining() {
        System.out.println("3. EXCEPTION CHAINING:");
        System.out.println("   Wrap low-level exceptions with meaningful context\n");
        
        try {
            // Simulate a low-level exception
            throw new SQLException("Connection timeout");
        } catch (SQLException e) {
            // Wrap with business context
            throw new ServiceException("Failed to process user data", e);
        }
    }
    
    /**
     * Demonstrates specific exception handling
     */
    public static void demonstrateSpecificExceptionHandling() {
        System.out.println("4. SPECIFIC EXCEPTION HANDLING:");
        System.out.println("   Catch specific exceptions before general ones\n");
        
        try {
            // Simulate different scenarios
            Random random = new Random();
            int scenario = random.nextInt(3);
            
            switch (scenario) {
                case 0:
                    throw new FileNotFoundException("Config file not found");
                case 1:
                    throw new SecurityException("Access denied");
                case 2:
                    throw new IllegalArgumentException("Invalid parameter");
            }
            
        } catch (FileNotFoundException e) {
            // Handle file not found specifically
            System.out.println("   ✓ FileNotFoundException: Create default config");
        } catch (SecurityException e) {
            // Handle security issues specifically
            System.out.println("   ✓ SecurityException: Request elevated permissions");
        } catch (IllegalArgumentException e) {
            // Handle invalid arguments specifically
            System.out.println("   ✓ IllegalArgumentException: Validate input parameters");
        } catch (Exception e) {
            // Catch all other exceptions
            System.out.println("   ✓ General Exception: Log and report");
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates exception suppression
     */
    public static void demonstrateExceptionSuppression() {
        System.out.println("5. EXCEPTION SUPPRESSION:");
        System.out.println("   Handle multiple exceptions in try-with-resources\n");
        
        try (Resource1 r1 = new Resource1();
             Resource2 r2 = new Resource2()) {
            
            r1.doSomething();
            r2.doSomething();
            System.out.println("   ✓ Resources used successfully");
            
        } catch (Exception e) {
            System.out.println("   ✓ Primary exception: " + e.getMessage());
            
            // Check for suppressed exceptions
            Throwable[] suppressed = e.getSuppressed();
            for (Throwable t : suppressed) {
                System.out.println("   ✓ Suppressed exception: " + t.getMessage());
            }
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates performance considerations in exception handling
     */
    public static void demonstratePerformanceConsiderations() {
        System.out.println("6. PERFORMANCE CONSIDERATIONS:");
        System.out.println("   Avoid exceptions for normal flow control\n");
        
        // Bad: Using exceptions for flow control
        long startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            try {
                if (i < 0) {
                    throw new IllegalArgumentException("Negative number");
                }
            } catch (IllegalArgumentException e) {
                // This will never execute in this loop
            }
        }
        long badTime = System.nanoTime() - startTime;
        
        // Good: Using normal flow control
        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            if (i < 0) {
                // Handle negative case without exception
            }
        }
        long goodTime = System.nanoTime() - startTime;
        
        System.out.println("   ✓ Exception-based loop time: " + badTime + " ns");
        System.out.println("   ✓ Normal flow loop time: " + goodTime + " ns");
        System.out.println("   ✓ Performance difference: " + (badTime - goodTime) + " ns");
        
        System.out.println();
    }
    
    /**
     * Demonstrates defensive programming techniques
     */
    public static void demonstrateDefensiveProgramming() {
        System.out.println("7. DEFENSIVE PROGRAMMING:");
        System.out.println("   Validate inputs and handle edge cases\n");
        
        // Example: Safe division method
        System.out.println("   Safe division examples:");
        System.out.println("   " + safeDivide(10, 2) + " (10 / 2)");
        System.out.println("   " + safeDivide(10, 0) + " (10 / 0)");
        System.out.println("   " + safeDivide(10, -1) + " (10 / -1)");
        
        // Example: Safe array access
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println("   Safe array access:");
        System.out.println("   " + safeArrayAccess(numbers, 2) + " (index 2)");
        System.out.println("   " + safeArrayAccess(numbers, 10) + " (index 10)");
        System.out.println("   " + safeArrayAccess(null, 0) + " (null array)");
        
        System.out.println();
    }
    
    // Helper methods for defensive programming
    public static double safeDivide(double numerator, double denominator) {
        if (denominator == 0) {
            LOGGER.warning("Division by zero attempted: " + numerator + " / " + denominator);
            return Double.NaN;
        }
        return numerator / denominator;
    }
    
    public static String safeArrayAccess(int[] array, int index) {
        if (array == null) {
            LOGGER.warning("Array is null");
            return "Array is null";
        }
        if (index < 0 || index >= array.length) {
            LOGGER.warning("Index out of bounds: " + index + " for array length " + array.length);
            return "Index out of bounds";
        }
        return String.valueOf(array[index]);
    }
}

/**
 * Custom exception for service layer
 */
class ServiceException extends RuntimeException {
    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}

/**
 * Mock SQLException for demonstration
 */
class SQLException extends Exception {
    public SQLException(String message) {
        super(message);
    }
}

/**
 * Mock resource classes for exception suppression demonstration
 */
class Resource1 implements AutoCloseable {
    public void doSomething() {
        // Simulate some work
    }
    
    @Override
    public void close() throws Exception {
        throw new Exception("Error closing Resource1");
    }
}

class Resource2 implements AutoCloseable {
    public void doSomething() {
        // Simulate some work
    }
    
    @Override
    public void close() throws Exception {
        throw new Exception("Error closing Resource2");
    }
} 