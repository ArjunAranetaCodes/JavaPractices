package AnimalSoundSystem;

public class Dog extends Animal {
    private String breed;
    
    public Dog(String name, String species, int age, String breed) {
        super(name, species, age);
        this.breed = breed;
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " says: Woof! Woof!");
    }
    
    @Override
    public void move() {
        System.out.println(name + " is running and wagging its tail!");
    }
    
    @Override
    public void eat() {
        System.out.println(name + " is eating dog food.");
    }
    
    // Dog-specific method
    public void fetch() {
        System.out.println(name + " is fetching the ball!");
    }
    
    public String getBreed() {
        return breed;
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Breed: " + breed);
    }
} 