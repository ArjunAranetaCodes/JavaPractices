/**
 * Tutorial: Built-in Annotations
 * Demonstrates Java built-in annotations
 */
// @Override - indicates method overriding
class Parent {
    public void display() {
        System.out.println("Parent display");
    }
}

class Child extends Parent {
    @Override
    public void display() {
        System.out.println("Child display");
    }
}

// @Deprecated - marks as deprecated
class OldClass {
    @Deprecated
    public void oldMethod() {
        System.out.println("This method is deprecated");
    }
    
    public void newMethod() {
        System.out.println("Use this method instead");
    }
}

// @SuppressWarnings - suppresses compiler warnings
@SuppressWarnings("unchecked")
class WarningExample {
    public void method() {
        java.util.List list = new java.util.ArrayList();
        list.add("Item");
    }
}

// @FunctionalInterface - marks functional interface
@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);
}

public class BuiltInAnnotations {
    public static void main(String[] args) {
        Child child = new Child();
        child.display();
        
        OldClass old = new OldClass();
        old.oldMethod();  // Deprecated warning
        
        Calculator calc = (a, b) -> a + b;
        System.out.println("Result: " + calc.calculate(5, 3));
    }
}











