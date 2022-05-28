class Animal {
    String sound;

    Animal(String sound) {
        this.sound = sound;
    }

    void makeSound() {
        System.out.println("Animal sound: " + sound);
    }
}

class Dog extends Animal {
    String breed;

    Dog(String sound, String breed) {
        super(sound); // Using super to call the constructor of the superclass
        this.breed = breed;
    }

    void displayInfo() {
        System.out.println("Dog breed: " + breed);
        super.makeSound(); // Using super to call the method of the superclass
    }
}

public class Main {
    public static void main(String[] args) {
        Dog myDog = new Dog("Woof", "Labrador");
        myDog.displayInfo();
    }
}
