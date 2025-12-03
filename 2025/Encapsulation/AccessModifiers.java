/**
 * Tutorial: Access Modifiers
 * Demonstrates private, default, protected, and public access
 */
class AccessModifiers {
    private int privateVar = 1;        // Only within same class
    int defaultVar = 2;                // Same package
    protected int protectedVar = 3;    // Same package + subclasses
    public int publicVar = 4;          // Everywhere
    
    private void privateMethod() {
        System.out.println("Private method");
    }
    
    void defaultMethod() {
        System.out.println("Default method");
    }
    
    protected void protectedMethod() {
        System.out.println("Protected method");
    }
    
    public void publicMethod() {
        System.out.println("Public method");
        // Can access all within same class
        System.out.println("Accessing all: " + privateVar + ", " + defaultVar + 
                          ", " + protectedVar + ", " + publicVar);
        privateMethod();
    }
}

class SubClass extends AccessModifiers {
    public void testAccess() {
        // Cannot access privateVar and privateMethod()
        // Can access defaultVar and defaultMethod() (same package)
        // Can access protectedVar and protectedMethod() (subclass)
        // Can access publicVar and publicMethod() (public)
        
        System.out.println("Default: " + defaultVar);
        System.out.println("Protected: " + protectedVar);
        System.out.println("Public: " + publicVar);
        
        defaultMethod();
        protectedMethod();
        publicMethod();
    }
}

public class AccessModifiersDemo {
    public static void main(String[] args) {
        AccessModifiers obj = new AccessModifiers();
        
        // Can only access public members from outside
        System.out.println("Public var: " + obj.publicVar);
        obj.publicMethod();
        
        SubClass sub = new SubClass();
        sub.testAccess();
    }
}


















