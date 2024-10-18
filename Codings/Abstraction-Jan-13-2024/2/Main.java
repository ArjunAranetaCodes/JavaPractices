abstract class Animal {
    abstract void makeSound();
    abstract void move();
}

class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Woof! Woof!");
    }

    @Override
    void move() {
        System.out.println("Running on four legs.");
    }
}

class Fish extends Animal {
    @Override
    void makeSound() {
        System.out.println("Blub! Blub!");
    }

    @Override
    void move() {
        System.out.println("Swimming in water.");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Fish fish = new Fish();

        dog.makeSound();
        dog.move();

        fish.makeSound();
        fish.move();
    }
}
