// Program 4
interface MyInterface {
    void myMethod();

    static void staticMethod() {
        System.out.println("Static method in MyInterface");
    }
}

class MyClass implements MyInterface {
    public void myMethod() {
        System.out.println("Implementation of myMethod"); 
    }
}

public class Main {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.myMethod();
        MyInterface.staticMethod();
    }
}
