/**
 * Tutorial: Class Basics
 * Demonstrates class definition, object creation, and instance variables
 */
public class ClassBasics {
    // Instance variables
    private String name;
    private int age;
    
    // Constructor
    public ClassBasics(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    // Getter methods
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    // Setter methods
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    // Instance method
    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
    
    public static void main(String[] args) {
        // Creating objects
        ClassBasics obj1 = new ClassBasics("Alice", 25);
        ClassBasics obj2 = new ClassBasics("Bob", 30);
        
        // Calling methods
        obj1.displayInfo();
        obj2.displayInfo();
        
        // Modifying object state
        obj1.setAge(26);
        System.out.println("\nAfter modification:");
        obj1.displayInfo();
    }
}













