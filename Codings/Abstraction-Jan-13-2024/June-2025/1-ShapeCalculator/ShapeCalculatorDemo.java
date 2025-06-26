package ShapeCalculator;

public class ShapeCalculatorDemo {
    public static void main(String[] args) {
        System.out.println("=== Shape Calculator Demo ===\n");
        
        // Creating different shapes
        Shape circle = new Circle("My Circle", "Red", 5.0);
        Shape rectangle = new Rectangle("My Rectangle", "Blue", 4.0, 6.0);
        Shape triangle = new Triangle("My Triangle", "Green", 3.0, 4.0, 5.0);
        
        // Display information for each shape
        circle.displayInfo();
        rectangle.displayInfo();
        triangle.displayInfo();
        
        // Demonstrating polymorphic behavior
        System.out.println("=== Polymorphic Behavior ===");
        Shape[] shapes = {circle, rectangle, triangle};
        
        for (Shape shape : shapes) {
            System.out.println(shape.getName() + " area: " + shape.calculateArea());
        }
    }
} 