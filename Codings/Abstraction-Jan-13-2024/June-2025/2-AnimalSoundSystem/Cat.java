package AnimalSoundSystem;

public class Cat extends Animal {
    private boolean isIndoor;
    
    public Cat(String name, String species, int age, boolean isIndoor) {
        super(name, species, age);
        this.isIndoor = isIndoor;
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " says: Meow! Purr...");
    }
    
    @Override
    public void move() {
        System.out.println(name + " is walking gracefully and silently.");
    }
    
    @Override
    public void eat() {
        System.out.println(name + " is eating cat food.");
    }
    
    // Cat-specific method
    public void climb() {
        System.out.println(name + " is climbing the furniture!");
    }
    
    public boolean isIndoor() {
        return isIndoor;
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Indoor Cat: " + isIndoor);
    }
} 