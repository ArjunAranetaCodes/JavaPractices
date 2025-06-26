package AnimalSoundSystem;

public class Bird extends Animal {
    private String featherColor;
    private boolean canFly;
    
    public Bird(String name, String species, int age, String featherColor, boolean canFly) {
        super(name, species, age);
        this.featherColor = featherColor;
        this.canFly = canFly;
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " says: Tweet! Tweet!");
    }
    
    @Override
    public void move() {
        if (canFly) {
            System.out.println(name + " is flying through the air!");
        } else {
            System.out.println(name + " is hopping on the ground.");
        }
    }
    
    @Override
    public void eat() {
        System.out.println(name + " is pecking at seeds.");
    }
    
    // Bird-specific method
    public void buildNest() {
        System.out.println(name + " is building a nest.");
    }
    
    public String getFeatherColor() {
        return featherColor;
    }
    
    public boolean canFly() {
        return canFly;
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Feather Color: " + featherColor);
        System.out.println("Can Fly: " + canFly);
    }
} 