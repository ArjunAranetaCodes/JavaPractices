interface MyInterface2 {
    void method2();
}

abstract class AbstractClass implements MyInterface2 {
    void commonMethod() {
        System.out.println("Common method in abstract class");
    }
}

class ConcreteClass extends AbstractClass {
    @Override
    public void method2() {
        System.out.println("Implementing MyInterface2"); 
    }
}

public class Main {
    public static void main(String[] args) {
        ConcreteClass obj = new ConcreteClass(); 
        obj.commonMethod(); 
        obj.method2();
    }
}
