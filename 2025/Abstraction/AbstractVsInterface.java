/**
 * Tutorial: Abstract Class vs Interface
 * Demonstrates differences between abstract classes and interfaces
 */
// Abstract class - can have both abstract and concrete methods
abstract class AbstractExample {
    // Abstract method
    abstract void abstractMethod();
    
    // Concrete method
    void concreteMethod() {
        System.out.println("Concrete method in abstract class");
    }
    
    // Can have instance variables
    protected int value = 10;
}

// Interface - all methods are abstract (before Java 8)
interface InterfaceExample {
    // Abstract method (implicitly public and abstract)
    void interfaceMethod();
    
    // Default method (Java 8+)
    default void defaultMethod() {
        System.out.println("Default method in interface");
    }
    
    // Static method (Java 8+)
    static void staticMethod() {
        System.out.println("Static method in interface");
    }
    
    // Cannot have instance variables (only constants)
    int CONSTANT = 100;  // Implicitly public, static, final
}

class Implementation extends AbstractExample implements InterfaceExample {
    @Override
    public void abstractMethod() {
        System.out.println("Implemented abstract method");
    }
    
    @Override
    public void interfaceMethod() {
        System.out.println("Implemented interface method");
    }
}

public class AbstractVsInterface {
    public static void main(String[] args) {
        Implementation obj = new Implementation();
        
        obj.abstractMethod();
        obj.concreteMethod();
        obj.interfaceMethod();
        obj.defaultMethod();
        
        InterfaceExample.staticMethod();
        System.out.println("Constant: " + InterfaceExample.CONSTANT);
    }
}











