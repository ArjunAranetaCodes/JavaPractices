```java
// Java code for serialization and deserialization
// of a Java object
import java.io.*;

class SerializationDemo {
    public static void main(String[] args) {
        Person person = new Person(30, "John Doe");
        String filename = "person.ser";

        // Serialization
        try {
            // Saving the object to a file
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of the object
            out.writeObject(person);

            out.close();
            file.close();

            System.out.println("Object has been serialized");
        } catch (IOException ex) {
            System.out.println("IOException is caught");
        }

        Person deserializedPerson = null;

        // Deserialization
        try {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of the object
            deserializedPerson = (Person) in.readObject();

            in.close();
            file.close();

            System.out.println("Object has been deserialized");
            System.out.println("Age = " + deserializedPerson.age);
            System.out.println("Name = " + deserializedPerson.name);
        } catch (IOException ex) {
            System.out.println("IOException is caught");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught");
        }
    }
}

class Person implements java.io.Serializable {
    public int age;
    public String name;

    // Default constructor
    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }
}
```

In this program, we have a `Person` class that implements the `Serializable` interface. The `Person` class has two fields: `age` (an integer) and `name` (a string).

In the `main` method of the `SerializationDemo` class, we create a `Person` object and then serialize it to a file named `person.ser` using the `ObjectOutputStream` class. After serialization, we deserialize the object from the file using the `ObjectInputStream` class and print the deserialized object's `age` and `name` fields.

The program follows a similar structure to the one you provided, but with a different class (`Person`) and different field names (`age` and `name`).