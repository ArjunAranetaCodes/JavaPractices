## Problem: 
Creating an Array of Shape Objects

## Description: 
Create a program that demonstrates the use of abstract class type arrays to store and manipulate shape information.

## Input:

Shape information:

Circle: radius = 5

Rectangle: length = 4, width = 3

Triangle: base = 3, height = 4

## Output:

Shape array:

Circle: radius = 5

Rectangle: length = 4, width = 3

Triangle: base = 3, height = 4

## Code Answer:
```Java
public abstract class Shape {
    public abstract double getArea();
}

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }
}

public class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getArea() {
        return length * width;
    }
}

public class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public double getArea() {
        return 0.5 * base * height;
    }
}

public class ShapeArray {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];

        shapes[0] = new Circle(5);
        shapes[1] = new Rectangle(4, 3);
        shapes[2] = new Triangle(3, 4);

        for (Shape shape : shapes) {
            System.out.println("Shape: " + shape.getClass().getSimpleName() + ", Area: " + shape.getArea());
        }
    }
}
```

File Name: ShapeArray.java

This program demonstrates the use of abstract class type arrays to store and manipulate shape information. The Shape abstract class represents a shape, and the Circle, Rectangle, and Triangle classes extend the Shape class. The ShapeArray class creates an array of Shape objects.

Note: Abstract class type arrays are used to store and manipulate objects of different classes that share a common abstract class. This is useful for creating arrays of objects that share a common base class, but have different implementations.