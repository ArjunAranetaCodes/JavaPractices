interface Shape {
    void draw();
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
}

class ColoredCircle extends Circle {
    String color;

    ColoredCircle(String color) {
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.println("Color: " + color);
    }
}

public class Main {
    public static void main(String[] args) {
        ColoredCircle coloredCircle = new ColoredCircle("Red");
        coloredCircle.draw();
    }
}
