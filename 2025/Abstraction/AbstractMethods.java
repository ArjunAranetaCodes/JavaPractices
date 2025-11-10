/**
 * Tutorial: Abstract Methods
 * Demonstrates abstract methods in abstract classes
 */
abstract class Shape {
    // Abstract method - no implementation
    public abstract double calculateArea();
    
    // Abstract method
    public abstract double calculatePerimeter();
    
    // Concrete method
    public void displayInfo() {
        System.out.println("Area: " + calculateArea());
        System.out.println("Perimeter: " + calculatePerimeter());
    }
}

class Circle extends Shape {
    private double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
    
    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}

class Rectangle extends Shape {
    private double length, width;
    
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    
    @Override
    public double calculateArea() {
        return length * width;
    }
    
    @Override
    public double calculatePerimeter() {
        return 2 * (length + width);
    }
}

public class AbstractMethods {
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 6);
        
        System.out.println("Circle:");
        circle.displayInfo();
        
        System.out.println("\nRectangle:");
        rectangle.displayInfo();
    }
}

