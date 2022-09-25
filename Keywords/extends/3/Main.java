class Box<T> {
    private T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}

class StringBox extends Box<String> {
    public StringBox(String value) {
        super(value);
    }
}

public class Main {
    public static void main(String[] args) {
        StringBox myStringBox = new StringBox("Hello, Generics!");
        System.out.println("Value in the box: " + myStringBox.getValue());
    }
}
