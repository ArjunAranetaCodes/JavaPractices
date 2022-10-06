// Program 5
public class Main {
    interface Shape {
        double calculateArea();
    }

    enum GeometricShape implements Shape {
        CIRCLE(3.5),
        RECTANGLE(4.0, 5.0),
        SQUARE(2.5);

        private final double[] dimensions;

        GeometricShape(double... dimensions) {
            this.dimensions = dimensions;
        }

        @Override
        public double calculateArea() {
            if (this == CIRCLE) {
                double radius = dimensions[0];
                return Math.PI * radius * radius;
            } else if (this == RECTANGLE) {
                double length = dimensions[0];
                double width = dimensions[1];
                return length * width;
            } else if (this == SQUARE) {
                return side * side;
            }
            return 0.0;
        }
    }

    public static void main(String[] args) {
        for (GeometricShape shape : GeometricShape.values()) {
            System.out.println("Area of " + shape + ": " + shape.calculateArea());
        }
    }
}
