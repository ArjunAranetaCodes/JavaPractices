/**
 * Basic String Template Example
 * Demonstrates simple string interpolation using Java 21's String Templates
 */
public class BasicStringTemplate {
    public static void main(String[] args) {
        // Basic string interpolation
        String name = "John";
        int age = 25;
        
        // Using STR template processor
        String message = STR."Hello, my name is \{name} and I am \{age} years old.";
        System.out.println(message);
        
        // Multiple expressions in a single template
        double price = 19.99;
        int quantity = 3;
        String order = STR."Order Summary:\n" +
                      STR."  Product: Widget\n" +
                      STR."  Price: $\{price}\n" +
                      STR."  Quantity: \{quantity}\n" +
                      STR."  Total: $\{price * quantity}";
        System.out.println(order);
        
        // Using expressions with method calls
        String greeting = STR."Welcome, \{name.toUpperCase()}!";
        System.out.println(greeting);
    }
} 