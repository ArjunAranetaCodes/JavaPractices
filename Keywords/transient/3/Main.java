import java.io.*;

class MyClass implements Serializable {
    transient int transientVariable = 10;

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        transientVariable = 0; // Reset transient variable during deserialization
    }
}

public class Main {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        System.out.println("Transient Variable: " + obj.transientVariable);
    }
}
