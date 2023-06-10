abstract class Shape {
    double area;

    abstract void calculateArea();

    void displayArea() {
        System.out.println("Area: " + area);
    }
}

class Circle extends Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    void calculateArea() {
        area = Math.PI * radius * radius;
    }
}

class AbstractShapeTest {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        circle.calculateArea();
        circle.displayArea();
    }
}
