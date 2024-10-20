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