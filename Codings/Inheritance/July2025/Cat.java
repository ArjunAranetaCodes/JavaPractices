/**
 * Cat class extending Animal - demonstrates inheritance with different behavior
 * Shows how different subclasses can override methods differently
 */
public class Cat extends Animal {
    // Additional fields specific to Cat
    private String color;
    private boolean isIndoor;
    
    // Default constructor
    public Cat() {
        super(); // Call parent constructor
        this.color = "Unknown";
        this.isIndoor = true;
    }
    
    // Parameterized constructor
    public Cat(String name, int age, String habitat, String color, boolean isIndoor) {
        super(name, age, "Cat", habitat); // Call parent constructor
        this.color = color;
        this.isIndoor = isIndoor;
    }
    
    // Method overriding - providing specific implementation
    @Override
    public void makeSound() {
        System.out.println(name + " meows: Meow! Meow!");
    }
    
    // Method overriding - calling parent method and adding functionality
    @Override
    public void displayInfo() {
        super.displayInfo(); // Call parent method
        System.out.println("Color: " + color);
        System.out.println("Indoor Cat: " + (isIndoor ? "Yes" : "No"));
    }
    
    // Method overriding - providing specific implementation
    @Override
    protected void move() {
        System.out.println(name + " is walking gracefully");
    }
    
    // Method overriding - providing specific implementation
    @Override
    public void sleep() {
        System.out.println(name + " is sleeping for 16 hours a day");
    }
    
    // New methods specific to Cat
    public void purr() {
        System.out.println(name + " is purring contentedly");
    }
    
    public void climb() {
        System.out.println(name + " is climbing the furniture");
    }
    
    public void hunt() {
        if (isIndoor) {
            System.out.println(name + " is hunting toy mice");
        } else {
            System.out.println(name + " is hunting real mice");
        }
    }
    
    // Getters and setters for Cat-specific fields
    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public boolean isIndoor() {
        return isIndoor;
    }
    
    public void setIndoor(boolean indoor) {
        isIndoor = indoor;
    }
} 