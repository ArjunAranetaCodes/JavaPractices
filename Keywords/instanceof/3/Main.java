interface Shape {
    void draw();
}

class Circle implements Shape {
    public void draw() {
        System.out.println("Drawing a circle");
    }
}

public class Main {
    public static void main(String[] args) {
        Shape myShape = new Circle();

        if (myShape instanceof Circle) {
        } else {
        }
    }
}
