package AnimalSoundSystem;

public class AnimalSoundDemo {
    public static void main(String[] args) {
        System.out.println("=== Animal Sound System Demo ===\n");
        
        // Creating different animals
        Animal dog = new Dog("Buddy", "Canine", 3, "Golden Retriever");
        Animal cat = new Cat("Whiskers", "Feline", 2, true);
        Animal bird = new Bird("Polly", "Parrot", 1, "Green", true);
        
        // Display information for each animal
        dog.displayInfo();
        cat.displayInfo();
        bird.displayInfo();
        
        // Demonstrating polymorphic behavior
        System.out.println("=== Animal Behaviors ===");
        Animal[] animals = {dog, cat, bird};
        
        for (Animal animal : animals) {
            System.out.println("\n" + animal.getName() + " activities:");
            animal.makeSound();
            animal.move();
            animal.eat();
            animal.sleep();
        }
        
        // Demonstrating specific behaviors
        System.out.println("\n=== Specific Behaviors ===");
        ((Dog) dog).fetch();
        ((Cat) cat).climb();
        ((Bird) bird).buildNest();
    }
} 