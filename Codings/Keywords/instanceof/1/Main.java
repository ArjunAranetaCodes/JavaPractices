class Animal {
}

class Dog extends Animal {
}

public class Main {
    public static void main(String[] args) {
        Animal myPet = new Dog();

        if (myPet instanceof Dog) {
            System.out.println("My pet is a dog!");
        } else {
            System.out.println("My pet is not a dog.");
        }
    }
}
