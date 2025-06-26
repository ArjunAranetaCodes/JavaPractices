package AnimalSoundSystem;

// Abstract class representing an animal
public abstract class Animal {
    protected String name;
    protected String species;
    protected int age;
    
    // Constructor
    public Animal(String name, String species, int age) {
        this.name = name;
        this.species = species;
        this.age = age;
    }
    
    // Abstract method - each animal must implement its own sound
    public abstract void makeSound();
    
    // Abstract method for movement behavior
    public abstract void move();
    
    // Abstract method for eating behavior
    public abstract void eat();
    
    // Concrete method - shared behavior
    public void sleep() {
        System.out.println(name + " the " + species + " is sleeping...");
    }
    
    // Concrete method to display animal info
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Species: " + species);
        System.out.println("Age: " + age + " years");
        System.out.println("------------------------");
    }
    
    // Getter methods
    public String getName() {
        return name;
    }
    
    public String getSpecies() {
        return species;
    }
    
    public int getAge() {
        return age;
    }
    
    // Setter methods
    public void setAge(int age) {
        this.age = age;
    }
} 