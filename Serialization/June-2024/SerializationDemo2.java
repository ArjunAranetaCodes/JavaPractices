import java.io.*;

class SerializationDemo2 {
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

class Animal implements Serializable {
    int age = 5;
    transient final int weight = 20;
}