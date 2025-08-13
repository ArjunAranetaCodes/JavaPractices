/**
 * Base class demonstrating inheritance concepts
 * This class will be extended by other animal types
 */
public class Animal {
    // Protected fields - accessible by subclasses
    protected String name;
    protected int age;
    protected String species;
    
    // Private field - only accessible within this class
    private String habitat;
    
    // Default constructor
    public Animal() {
        this.name = "Unknown";
        this.age = 0;
        this.species = "Unknown";
        this.habitat = "Unknown";
    }
    
    // Parameterized constructor
    public Animal(String name, int age, String species, String habitat) {
        this.name = name;
        this.age = age;
        this.species = species;
        this.habitat = habitat;
    }
    
    // Public methods - accessible by all
    public void makeSound() {
        System.out.println(name + " makes a generic animal sound");
    }
    
    public void eat() {
        System.out.println(name + " is eating");
    }
    
    public void sleep() {
        System.out.println(name + " is sleeping");
    }
    
    // Protected method - accessible by subclasses
    protected void move() {
        System.out.println(name + " is moving");
    }
    
    // Public getter for private field
    public String getHabitat() {
        return habitat;
    }
    
    // Public setter for private field
    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }
    
    // Method that can be overridden by subclasses
    public void displayInfo() {
        System.out.println("Animal: " + name);
        System.out.println("Age: " + age);
        System.out.println("Species: " + species);
        System.out.println("Habitat: " + habitat);
    }
    
    // Final method - cannot be overridden by subclasses
    public final void breathe() {
        System.out.println(name + " is breathing");
    }
    
    // Static method - belongs to class, not instance
    public static void animalFact() {
        System.out.println("All animals are multicellular organisms");
    }
} 