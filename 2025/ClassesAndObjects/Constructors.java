/**
 * Tutorial: Constructors
 * Demonstrates default, parameterized, and copy constructors
 */
public class Constructors {
    private String name;
    private int value;
    
    // Default constructor
    public Constructors() {
        this.name = "Default";
        this.value = 0;
    }
    
    // Parameterized constructor
    public Constructors(String name, int value) {
        this.name = name;
        this.value = value;
    }
    
    // Copy constructor
    public Constructors(Constructors other) {
        this.name = other.name;
        this.value = other.value;
    }
    
    // Constructor chaining
    public Constructors(String name) {
        this(name, 0);  // Calls parameterized constructor
    }
    
    public void display() {
        System.out.println("Name: " + name + ", Value: " + value);
    }
    
    public static void main(String[] args) {
        // Using default constructor
        Constructors obj1 = new Constructors();
        System.out.println("Default constructor:");
        obj1.display();
        
        // Using parameterized constructor
        Constructors obj2 = new Constructors("Test", 100);
        System.out.println("\nParameterized constructor:");
        obj2.display();
        
        // Using copy constructor
        Constructors obj3 = new Constructors(obj2);
        System.out.println("\nCopy constructor:");
        obj3.display();
        
        // Using constructor with one parameter
        Constructors obj4 = new Constructors("Single");
        System.out.println("\nConstructor chaining:");
        obj4.display();
    }
}
















