```java
import java.io.*;

class Animal implements Serializable {
    int age = 5;
    transient final int weight = 20;
}

class SerializationDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Animal animal1 = new Animal();

        // Serialization
        System.out.println("Serialization started");
        FileOutputStream fos = new FileOutputStream("animal.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(animal1);
        System.out.println("Serialization ended");

        // Deserialization
        System.out.println("Deserialization started");
        FileInputStream fis = new FileInputStream("animal.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Animal animal2 = (Animal) ois.readObject();
        System.out.println("Deserialization ended");

        System.out.println("Animal object data");
        System.out.println("Age: " + animal2.age);
        System.out.println("Weight: " + animal2.weight);
    }
}
```

In this program, we have an `Animal` class that implements the `Serializable` interface. The `Animal` class has two fields: `age` (an integer) and `weight` (a `final` integer marked as `transient`).

In the `main` method of the `SerializationDemo` class, we create an `Animal` object (`animal1`) and serialize it to a file named `animal.ser` using the `ObjectOutputStream` class. After serialization, we deserialize the object from the file using the `ObjectInputStream` class and store it in a new `Animal` object (`animal2`).

Since the `weight` field is marked as `transient` and `final`, its value will not be serialized or deserialized. Instead, it will be initialized with the default value for the `int` type, which is `0`.

Finally, we print the values of the `age` and `weight` fields of the deserialized `animal2` object.

The output of this program will be:

```
Serialization started
Serialization ended
Deserialization started
Deserialization ended
Animal object data
Age: 5
Weight: 0
```

Note that the value of the `weight` field is `0` after deserialization, as it was not serialized due to the `transient` keyword.