abstract class Animal {
    String name;

    abstract void makeSound();

    void displayInfo() {
        System.out.println("Name: " + name);
    }
}

class Dog extends Animal {
}

class AbstractAnimalTest {
    public static void main(String[] args) {
        Dog dog = new Dog("Buddy", "Labrador");
        dog.displayInfo();
        dog.makeSound();
    }
}
