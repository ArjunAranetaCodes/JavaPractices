/**
 * Dog class extending Animal - demonstrates single inheritance
 * Shows method overriding and adding new functionality
 */
public class Dog extends Animal {
    // Additional fields specific to Dog
    private String breed;
    private boolean isTrained;
    
    // Default constructor
    public Dog() {
        super(); // Call parent constructor
        this.breed = "Unknown";
        this.isTrained = false;
    }
    
    // Parameterized constructor
    public Dog(String name, int age, String habitat, String breed, boolean isTrained) {
        super(name, age, "Dog", habitat); // Call parent constructor
        this.breed = breed;
        this.isTrained = isTrained;
    }
    
    // Method overriding - providing specific implementation
    @Override
    public void makeSound() {
        System.out.println(name + " barks: Woof! Woof!");
    }
    
    // Method overriding - calling parent method and adding functionality
    @Override
    public void displayInfo() {
        super.displayInfo(); // Call parent method
        System.out.println("Breed: " + breed);
        System.out.println("Trained: " + (isTrained ? "Yes" : "No"));
    }
    
    // Method overriding - providing specific implementation
    @Override
    protected void move() {
        System.out.println(name + " is running on four legs");
    }
    
    // New methods specific to Dog
    public void fetch() {
        System.out.println(name + " is fetching the ball");
    }
    
    public void wagTail() {
        System.out.println(name + " is wagging its tail");
    }
    
    public void guard() {
        if (isTrained) {
            System.out.println(name + " is guarding the house");
        } else {
            System.out.println(name + " is playing instead of guarding");
        }
    }
    
    // Getters and setters for Dog-specific fields
    public String getBreed() {
        return breed;
    }
    
    public void setBreed(String breed) {
        this.breed = breed;
    }
    
    public boolean isTrained() {
        return isTrained;
    }
    
    public void setTrained(boolean trained) {
        isTrained = trained;
    }
} 