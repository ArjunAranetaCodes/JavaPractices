// Program 3
interface MyInterface {
    void myMethod();

    default void defaultMethod() {
        System.out.println("Default implementation of defaultMethod");
    }
}

class MyClass implements MyInterface {
    public void myMethod() {
    }
}

public class Main {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.myMethod();
    }
}
