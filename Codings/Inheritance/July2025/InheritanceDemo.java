/**
 * InheritanceDemo - Main class demonstrating inheritance concepts
 * Shows polymorphism, method overriding, and inheritance hierarchy
 */
public class InheritanceDemo {
    public static void main(String[] args) {
        System.out.println("=== INHERITANCE DEMONSTRATION ===\n");
        
        // 1. Basic Inheritance - Creating different animal types
        System.out.println("1. BASIC INHERITANCE EXAMPLES:");
        System.out.println("================================");
        
        Animal genericAnimal = new Animal("Generic", 5, "Unknown", "Forest");
        Dog dog = new Dog("Buddy", 3, "Home", "Golden Retriever", true);
        Cat cat = new Cat("Whiskers", 2, "Home", "Orange", true);
        Bird bird = new Bird("Tweety", 1, "Cage", 15.5, true);
        
        // Display information for each animal
        genericAnimal.displayInfo();
        System.out.println();
        dog.displayInfo();
        System.out.println();
        cat.displayInfo();
        System.out.println();
        bird.displayInfo();
        System.out.println();
        
        // 2. Polymorphism - Using parent class reference
        System.out.println("2. POLYMORPHISM EXAMPLES:");
        System.out.println("==========================");
        
        Animal[] animals = {genericAnimal, dog, cat, bird};
        
        for (Animal animal : animals) {
            System.out.println("Animal: " + animal.name);
            animal.makeSound(); // Polymorphic method call
            animal.move();      // Polymorphic method call
            animal.eat();       // Inherited method
            animal.breathe();   // Final method - cannot be overridden
            System.out.println();
        }
        
        // 3. Method Overriding Demonstration
        System.out.println("3. METHOD OVERRIDING EXAMPLES:");
        System.out.println("===============================");
        
        // Each animal has its own implementation of makeSound()
        System.out.println("Different animals make different sounds:");
        dog.makeSound();
        cat.makeSound();
        bird.makeSound();
        System.out.println();
        
        // 4. Access Modifiers Demonstration
        System.out.println("4. ACCESS MODIFIERS DEMONSTRATION:");
        System.out.println("===================================");
        
        // Public methods - accessible everywhere
        dog.eat();
        cat.sleep();
        bird.fly();
        
        // Protected methods - accessible through inheritance
        // dog.move(); // This would work if called from within the class
        
        // Private fields - accessed through public getters/setters
        System.out.println("Dog's habitat: " + dog.getHabitat());
        dog.setHabitat("Backyard");
        System.out.println("Updated dog's habitat: " + dog.getHabitat());
        System.out.println();
        
        // 5. Static Methods
        System.out.println("5. STATIC METHODS:");
        System.out.println("==================");
        
        Animal.animalFact(); // Called on class, not instance
        Pet.petFact();       // Interface static method
        System.out.println();
        
        // 6. Multiple Inheritance through Interfaces
        System.out.println("6. MULTIPLE INHERITANCE (INTERFACES):");
        System.out.println("=====================================");
        
        PetDog petDog = new PetDog("Max", 4, "Home", "Labrador", 
                                   true, "John", false);
        
        petDog.displayInfo();
        System.out.println();
        
        // Interface methods
        petDog.play();
        petDog.beFriendly();
        petDog.getVaccinated();
        petDog.showAffection(); // Overridden default method
        
        // Class-specific methods
        petDog.fetch();
        petDog.goForWalk();
        petDog.sleepInBed();
        System.out.println();
        
        // 7. Constructor Chaining
        System.out.println("7. CONSTRUCTOR CHAINING:");
        System.out.println("========================");
        
        System.out.println("Creating a new PetDog with constructor chaining:");
        PetDog newPetDog = new PetDog("Luna", 2, "Apartment", "Poodle", 
                                      false, "Sarah", true);
        newPetDog.displayInfo();
        System.out.println();
        
        // 8. instanceof Operator
        System.out.println("8. INSTANCEOF OPERATOR:");
        System.out.println("=======================");
        
        System.out.println("petDog instanceof Animal: " + (petDog instanceof Animal));
        System.out.println("petDog instanceof Dog: " + (petDog instanceof Dog));
        System.out.println("petDog instanceof Pet: " + (petDog instanceof Pet));
        System.out.println("petDog instanceof PetDog: " + (petDog instanceof PetDog));
        System.out.println("dog instanceof Pet: " + (dog instanceof Pet)); // false
        System.out.println();
        
        // 9. Type Casting
        System.out.println("9. TYPE CASTING:");
        System.out.println("================");
        
        Animal animalRef = petDog; // Upcasting (implicit)
        System.out.println("Upcasting PetDog to Animal - calling makeSound():");
        animalRef.makeSound();
        
        if (animalRef instanceof PetDog) {
            PetDog castedPetDog = (PetDog) animalRef; // Downcasting (explicit)
            System.out.println("Downcasting Animal to PetDog - calling goForWalk():");
            castedPetDog.goForWalk();
        }
        System.out.println();
        
        // 10. Final Methods and Classes
        System.out.println("10. FINAL METHODS:");
        System.out.println("==================");
        
        System.out.println("All animals can breathe (final method):");
        genericAnimal.breathe();
        dog.breathe();
        cat.breathe();
        bird.breathe();
        petDog.breathe();
        
        System.out.println("\n=== INHERITANCE DEMONSTRATION COMPLETE ===");
    }
} 