/**
 * Bird class extending Animal - demonstrates inheritance with flying behavior
 * Shows how subclasses can have unique methods and behaviors
 */
public class Bird extends Animal {
    // Additional fields specific to Bird
    private double wingspan;
    private boolean canFly;
    
    // Default constructor
    public Bird() {
        super(); // Call parent constructor
        this.wingspan = 0.0;
        this.canFly = true;
    }
    
    // Parameterized constructor
    public Bird(String name, int age, String habitat, double wingspan, boolean canFly) {
        super(name, age, "Bird", habitat); // Call parent constructor
        this.wingspan = wingspan;
        this.canFly = canFly;
    }
    
    // Method overriding - providing specific implementation
    @Override
    public void makeSound() {
        System.out.println(name + " chirps: Tweet! Tweet!");
    }
    
    // Method overriding - calling parent method and adding functionality
    @Override
    public void displayInfo() {
        super.displayInfo(); // Call parent method
        System.out.println("Wingspan: " + wingspan + " cm");
        System.out.println("Can Fly: " + (canFly ? "Yes" : "No"));
    }
    
    // Method overriding - providing specific implementation
    @Override
    protected void move() {
        if (canFly) {
            System.out.println(name + " is flying through the air");
        } else {
            System.out.println(name + " is walking on the ground");
        }
    }
    
    // New methods specific to Bird
    public void fly() {
        if (canFly) {
            System.out.println(name + " is soaring high in the sky");
        } else {
            System.out.println(name + " cannot fly");
        }
    }
    
    public void buildNest() {
        System.out.println(name + " is building a nest");
    }
    
    public void layEggs() {
        System.out.println(name + " is laying eggs");
    }
    
    public void migrate() {
        if (canFly) {
            System.out.println(name + " is migrating to warmer climates");
        } else {
            System.out.println(name + " stays in the same place");
        }
    }
    
    // Getters and setters for Bird-specific fields
    public double getWingspan() {
        return wingspan;
    }
    
    public void setWingspan(double wingspan) {
        this.wingspan = wingspan;
    }
    
    public boolean canFly() {
        return canFly;
    }
    
    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }
} 