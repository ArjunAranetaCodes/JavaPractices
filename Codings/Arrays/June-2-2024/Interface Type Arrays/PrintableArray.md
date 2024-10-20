## Problem: 
Creating an Array of Printable Objects

## Description: 
Create a program that demonstrates the use of interface type arrays to store and manipulate printable objects.

## Input:

Printable information:

Document: "Hello, World!"

Image: "logo.png"

Message: "Goodbye, World!"

## Output:

Printable array:

Document: "Hello, World!"

Image: "logo.png"

Message: "Goodbye, World!"

## Code Answer:
```Java
public class PrintableArray {
    public static void main(String[] args) {
        Printable[] printables = new Printable[3];

        printables[0] = new Document("Hello, World!");
        printables[1] = new Image("logo.png");
        printables[2] = new Message("Goodbye, World!");

        for (Printable printable : printables) {
            printable.print();
        }
    }
}

public interface Printable {
    void print();
}

public class Document implements Printable {
    private String text;

    public Document(String text) {
        this.text = text;
    }

    public void print() {
        System.out.println("Document: " + text);
    }
}

public class Image implements Printable {
    private String filename;

    public Image(String filename) {
        this.filename = filename;
    }

    public void print() {
        System.out.println("Image: " + filename);
    }
}

public class Message implements Printable {
    private String text;

    public Message(String text) {
        this.text = text;
    }

    public void print() {
        System.out.println("Message: " + text);
    }
}
```

File Name: PrintableArray.java

This program demonstrates the use of interface type arrays to store and manipulate printable objects. The Printable interface represents a printable object, and the Document, Image, and Message classes implement the Printable interface. The PrintableArray class creates an array of Printable objects.

Note: Interface type arrays are used to store and manipulate objects that implement a common interface. This is useful for creating arrays of objects that share a common behavior or functionality.