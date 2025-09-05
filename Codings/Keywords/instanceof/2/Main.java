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
            System.out.println("My shape is a circle!");
        } else {
            System.out.println("My shape is not a circle.");
        }
    }
}
