/**
 * Tutorial: Static Members
 * Demonstrates static variables, methods, and blocks
 */
public class StaticMembers {
    // Instance variable
    private int instanceVar;
    
    // Static variable (shared by all instances)
    private static int staticVar = 0;
    
    // Static block (executed once when class is loaded)
    static {
        System.out.println("Static block executed");
        staticVar = 100;
    }
    
    // Constructor
    public StaticMembers(int instanceVar) {
        this.instanceVar = instanceVar;
        staticVar++;  // Modifying static variable
    }
    
    // Instance method
    public void display() {
        System.out.println("Instance: " + instanceVar + ", Static: " + staticVar);
    }
    
    // Static method
    public static void staticMethod() {
        System.out.println("Static method called, staticVar: " + staticVar);
        // Cannot access instanceVar here
    }
    
    // Static method to get static variable
    public static int getStaticVar() {
        return staticVar;
    }
    
    public static void main(String[] args) {
        System.out.println("Static variable before objects: " + getStaticVar());
        
        StaticMembers obj1 = new StaticMembers(10);
        obj1.display();
        
        StaticMembers obj2 = new StaticMembers(20);
        obj2.display();
        
        // Static variable is shared
        System.out.println("\nStatic variable after creating objects: " + getStaticVar());
        
        // Calling static method
        staticMethod();
    }
}














