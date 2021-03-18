public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(5.0);
        Rectangle rectangle = new Rectangle(4.0, 6.0);

        System.out.println("Circle Area: " + circle.calculateArea());       // Output: Circle Area: 78.53981633974483
        System.out.println("Rectangle Area: " + rectangle.calculateArea()); // Output: Rectangle Area: 24.0
    }
}

abstract class Shape<T extends Number> {
    abstract T calculateArea();
}

class Circle extends Shape<Double> {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    Double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class
