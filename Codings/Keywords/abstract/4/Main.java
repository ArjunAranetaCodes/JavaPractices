abstract class Shape {
    int sides;

    abstract void calculateArea();
}

class Square extends Shape {
    Square(int sides) {
        this.sides = sides;
    }

    void calculateArea() {
        System.out.println("Square Area: " + sides * sides);
    }
}

class Main {
    public static void main(String[] args) {
        Square square = new Square(4);
        square.calculateArea();
    }
}
