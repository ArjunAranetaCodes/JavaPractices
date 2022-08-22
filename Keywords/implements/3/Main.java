class MyBaseClass {
    void baseMethod() {
        System.out.println("Base class method");
    }
}

interface MyExtendedInterface {
    void extendedMethod();
}

class CombinedClass extends MyBaseClass implements MyExtendedInterface {
    @Override
    public void extendedMethod() {
        System.out.println("Implementing MyExtendedInterface");
    }
}

public class Main {
    public static void main(String[] args) {
        CombinedClass obj = new CombinedClass(); 
        obj.baseMethod(); 
        obj.extendedMethod();
    }
}
