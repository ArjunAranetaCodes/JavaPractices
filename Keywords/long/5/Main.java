// Program 5
interface Interface1 {
    void method1();
}

interface Interface2 {
    void method2();
}

interface CombinedInterface extends Interface1, Interface2 {
    void combinedMethod();
}

class MyClass implements CombinedInterface {
    public void method1() {
        System.out.println("Implementation of method1");
    }

    public void method2() {
        System.out.println("Implementation of method2");
    }

    public void combinedMethod() {
        System.out.println("Implementation of combinedMethod");
    }
}

public class Main {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.method1();
        obj.method2();
        obj.combinedMethod();
    }
}
