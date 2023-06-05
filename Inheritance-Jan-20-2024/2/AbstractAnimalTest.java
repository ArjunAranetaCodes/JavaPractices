abstract class Animal {
    String name;

    abstract void makeSound();

    void displayInfo() {
        System.out.println("Name: " + name);
    }
}

class Dog extends Animal {
    String breed;

    Dog(String name, String breed) {
        this.name = name;
    }

    void makeSound() {
        System.out.println("Bark");
    }
}

class AbstractAnimalTest {
    public static void main(String[] args) {
        Dog dog = new Dog("Buddy", "Labrador");
        dog.displayInfo();
        dog.makeSound();
    }
}
