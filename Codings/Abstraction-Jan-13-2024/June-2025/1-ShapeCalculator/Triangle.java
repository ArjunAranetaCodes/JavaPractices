package ShapeCalculator;

public class Triangle extends Shape {
    private double sideA;
    private double sideB;
    private double sideC;
    
    public Triangle(String name, String color, double sideA, double sideB, double sideC) {
        super(name, color);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }
    
    @Override
    public double calculateArea() {
        // Using Heron's formula
        double s = (sideA + sideB + sideC) / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }
    
    @Override
    public double calculatePerimeter() {
        return sideA + sideB + sideC;
    }
    
    public double getSideA() {
        return sideA;
    }
    
    public double getSideB() {
        return sideB;
    }
    
    public double getSideC() {
        return sideC;
    }
} 