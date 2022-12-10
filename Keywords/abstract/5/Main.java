interface Drawable {
    void draw();
}

abstract class Shape implements Drawable {
    int sides;

    abstract void calculateArea();
}

class Triangle extends Shape {
    Triangle(int sides) {
        this.sides = sides;
    }

    void draw() {
        System.out.println("Drawing Triangle");
    }

    void calculateArea() {
        System.out.println("Triangle Area: " + 0.5 * sides * sides);
    }
}

class Main {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(3);
        triangle.draw();
        triangle.calculateArea();
    }
}
