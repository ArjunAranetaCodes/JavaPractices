package ShapeCalculator;

// Abstract class representing a geometric shape
public abstract class Shape {
    protected String color;
    protected String name;
    
    // Constructor
    public Shape(String name, String color) {
        this.name = name;
        this.color = color;
    }
    
    // Abstract method - must be implemented by subclasses
    public abstract double calculateArea();
    
    // Abstract method for perimeter calculation
    public abstract double calculatePerimeter();
    
    // Concrete method - shared behavior
    public void displayInfo() {
        System.out.println("Shape: " + name);
        System.out.println("Color: " + color);
        System.out.println("Area: " + calculateArea());
        System.out.println("Perimeter: " + calculatePerimeter());
        System.out.println("------------------------");
    }
    
    // Getter methods
    public String getColor() {
        return color;
    }
    
    public String getName() {
        return name;
    }
    
    // Setter methods
    public void setColor(String color) {
        this.color = color;
    }
} 