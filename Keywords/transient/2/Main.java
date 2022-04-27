import java.io.*;

class MyClass implements Serializable {
    transient int transientVariable = 10;
    int nonTransientVariable = 20;
}

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        MyClass obj = new MyClass();

        // Serialization
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data.ser"));
        out.writeObject(obj);
        out.close();

        // Deserialization
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.ser"));
        MyClass newObj = (MyClass) in.readObject();
        in.close();

        System.out.println("Transient Variable after Deserialization: " + newObj.transientVariable);
        System.out.println("Non-Transient Variable after Deserialization: " + newObj.nonTransientVariable);
    }
}
