class Parent {
    static void staticMethod() {
        System.out.println("Static method in Parent");
    }
}

class Child extends Parent {
    static void staticMethod() {
        super.staticMethod(); // Using super to call static method of the superclass
        System.out.println("Static method in Child");
    }
}

public class Main {
    public static void main(String[] args) {
        Child.staticMethod();
    }
}
 